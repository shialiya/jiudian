package cn.scau.web;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.scau.page.Page;
import cn.scau.pojo.DRS;
import cn.scau.pojo.DailyRate;
import cn.scau.pojo.DailyRateM;
import cn.scau.pojo.DailyRateSearch;
import cn.scau.pojo.RateType;
import cn.scau.pojo.ReservationWithBLOBs;
import cn.scau.pojo.RoomType;
import cn.scau.pojo.RoomType;
import cn.scau.service.RoomTypeService;
import cn.scau.service.DRSService;
import cn.scau.service.DailyRateService;
import cn.scau.service.RateTypeService;
import cn.scau.service.ReservationService;
import cn.scau.service.RoomTypeService;

@Controller
@RequestMapping("")
public class ReservationController {
	@Autowired
	ReservationService r;
	@Autowired
	RateTypeService rate;
	@Autowired
	RoomTypeService room;
	@Autowired
	DailyRateService drs;
	@Autowired
	DRSService d;
	
	@RequestMapping("rsv_list")
	public String tolist(Model model,Page page) {
		ReservationWithBLOBs rsv=new ReservationWithBLOBs();
		List<ReservationWithBLOBs> cs=r.list(page, rsv);
		int total=r.total(rsv);
		page.setTotal(total);
		model.addAttribute("cs",cs);
		model.addAttribute("page",page);
		model.addAttribute("total",total);
		Page page1=new Page();
		page1.setCount(9999);
		page1.setStart(0);
		RateType rateType=new RateType();
		List<RateType> s=rate.list(page1,rateType);
		model.addAttribute("s",s);
		RoomType roomType=new RoomType();
		page1.setStart(0);
		List<RoomType> r=room.list(page1, roomType);
		model.addAttribute("r",r);
		model.addAttribute("sear",1);
		return "listReservation";
	}
	
	@RequestMapping("send_mail")
	public String sendMail (Integer id, Model model) {
		int j;
		j=r.sendMail(id);
		model.addAttribute("j",j);
		return "addReservation";
	}
	
//	@RequestMapping(value="query_rate_rsv",method={RequestMethod.POST})
//	@ResponseBody
//	public List<DailyRateM> showRate(HttpServletRequest d){
//		System.out.println(d.getParameter("ciDate"));
//		System.out.println(d.getParameter("rmType"));
//		List<DailyRateM> dailyRateMs;
////		=drs.list(d.getCiDate(), d.getCoDate(), d.getRmType(), d.getRateType());
////		if(dailyRateMs.size()!=(d.getCiDate().getTime()-d.getCoDate().getTime())/(3600*24*1000))
//			dailyRateMs=null;
//		return dailyRateMs;  
//	}
	
	@RequestMapping("show_rsv_add")
	public String showAdd(Model model,String rmType,String rateType, double sum, Integer rest,Date ciDate, Date coDate) {
		DailyRateM dailyRateM=new DailyRateM();
		dailyRateM.setCiDate(ciDate);
		dailyRateM.setCoDate(coDate);
		dailyRateM.setRateType(rateType);
		dailyRateM.setRest(rest);
		dailyRateM.setRmType(rmType);
		List<DRS> list=d.show(dailyRateM);
		Date date;
		int count=(int)((dailyRateM.getCoDate().getTime()-dailyRateM.getCiDate().getTime())/(3600*24*1000));
			if(list.get(0).getFreeCancelDate()==999) {
				long time=System.currentTimeMillis();
				 date=new Date(time);
			}else {
				long currTime=dailyRateM.getCiDate().getTime() ; 
				long oneDay =1000*60*60*24*list.get(0).getFreeCancelDate(); 
				long beforDayTime =currTime-oneDay ; 
				date=new Date(beforDayTime);
			}
		model.addAttribute("list", list);
		model.addAttribute("d",date);
		model.addAttribute("sum",sum);
		model.addAttribute("info",dailyRateM);
		return "addReservation";
	}
	
	@RequestMapping("rsv_add")
	public String add(Model model,ReservationWithBLOBs rsv) {
		long time=System.currentTimeMillis();
		Date date;
		int j=1;
		 date=new Date(time);
		rsv.setMadeDate(date);
		rsv.setNotes(rsv.getNotes()+"\n ### Created on "+date);
		try {
			r.add(rsv);
		} catch (Exception e) {
			j=0;
		}
		model.addAttribute("j", j);
		return "addReservation";
	}
	
	@RequestMapping("rsv_delete")
	public String delete(Integer id) {
		r.delete(id);
		return "redirect:/rsv_list";
	}
	
	@RequestMapping("rsv_delete_group")
	public String deleteg(Integer[] ids) {
		for(int i=0;i<ids.length;i++) {
			System.out.println(ids[i]);
			r.delete(ids[i]);}
		return "redirect:/rsv_list";
	}
	
	@RequestMapping("rsv_edit")
	public String edit(Integer id,Model model) {
		ReservationWithBLOBs rsv=r.get(id);
		model.addAttribute("c",rsv);
		Page page=new Page();
		page.setCount(9999);
		RateType rateType=new RateType();
		List<RateType> s=rate.list(page,rateType);
		model.addAttribute("s",s);
		RoomType roomType=new RoomType();
		page.setStart(0);
		List<RoomType> r=room.list(page, roomType);
		model.addAttribute("r",r);
		return "editReservation";
	}
	
	@RequestMapping("rsv_edit_confirm")
	public String editComfirm(ReservationWithBLOBs rsv, Model model) {
		ReservationWithBLOBs rsvm=new ReservationWithBLOBs();
		try {
			 rsvm=r.get(rsv.getConfirmID());
		} catch (Exception e) {
			
		}
		Date date;
		DailyRateM dailyRateM=new DailyRateM();
		dailyRateM.setCiDate(rsv.getCiDate());
		dailyRateM.setCoDate(rsv.getCoDate());
		dailyRateM.setRateType(rsv.getRateType());
		dailyRateM.setRmType(rsv.getRmType());
		dailyRateM.setRest(rsv.getQuantity());
		if(dailyRateM.getCiDate().toString().equals(rsvm.getCiDate().toString())&&dailyRateM.getCoDate().toString().equals(rsvm.getCoDate().toString())&&dailyRateM.getRateType().equals(rsvm.getRateType())&&dailyRateM.getRmType().equals(rsvm.getRmType())&&dailyRateM.getRest()==rsvm.getQuantity()) {
			model.addAttribute("sum",rsvm.getAmount());
			model.addAttribute("d",rsvm.getFreeCancelDate());
		}
		else {
		List<DRS> list=d.show(dailyRateM);
		
		double sum=0;
		int count=(int)((dailyRateM.getCoDate().getTime()-dailyRateM.getCiDate().getTime())/(3600*24*1000));
		if(list.size()==count) {
			for(int i=0;i<list.size();i++)
				sum+=list.get(i).getRate();
			sum*=dailyRateM.getRest();
			if(list.get(0).getFreeCancelDate()==999) {
				long time=System.currentTimeMillis();
				 date=new Date(time);
			}else {
				long currTime=dailyRateM.getCiDate().getTime() ; 
				long oneDay =1000*60*60*24*list.get(0).getFreeCancelDate(); 
				long beforDayTime =currTime-oneDay ; 
				date=new Date(beforDayTime);
			}
			model.addAttribute("list", list);
			model.addAttribute("d",date);
		}
		else {
			sum=0;
		}
		model.addAttribute("sum",sum);

		}
		Page page=new Page();
		page.setCount(9999);
		RateType rateType=new RateType();
		List<RateType> s=rate.list(page,rateType);
		model.addAttribute("s",s);
		RoomType roomType=new RoomType();
		page.setStart(0);
		List<RoomType> r=room.list(page, roomType);
		model.addAttribute("r",r);
		model.addAttribute("info",dailyRateM);
		model.addAttribute("c",rsv);
		return "editReservationConfirm";
	}
	
	@RequestMapping("rsv_update")
	public String update(Model model,ReservationWithBLOBs rsv) {
		int j=1;
		try {
			r.update(rsv);

		} catch (Exception e) {
			j=0;
		}
		model.addAttribute("j", j);
		return "addReservation";
	}

	
	@RequestMapping("search_rsv")
	public String search(Model model,ReservationWithBLOBs rsv) {
		
		List<ReservationWithBLOBs> list = r.search(rsv);
		model.addAttribute("cs",list);
		Page page=new Page();
		page.setCount(9999);
		RateType rateType=new RateType();
		List<RateType> s=rate.list(page,rateType);
		model.addAttribute("s",s);
		RoomType roomType=new RoomType();
		page.setStart(0);
		List<RoomType> r=room.list(page, roomType);
		model.addAttribute("r",r);
		model.addAttribute("total",list.size());
		page.setStart(0);
		page.setCount(9999);
		page.setTotal(9999);
		model.addAttribute("page",page);
		return "listReservation";
	}
}
