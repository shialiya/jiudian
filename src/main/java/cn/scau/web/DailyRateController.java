package cn.scau.web;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.scau.page.Page;
import cn.scau.pojo.DRS;
import cn.scau.pojo.DailyRateM;
import cn.scau.pojo.RateType;
import cn.scau.pojo.RoomType;
import cn.scau.service.DRSService;
import cn.scau.service.RateTypeService;
import cn.scau.service.RoomTypeService;

@Controller
@RequestMapping("")
public class DailyRateController {

	@Autowired
	DRSService d;
	@Autowired
	RateTypeService rate;
	@Autowired
	RoomTypeService room;
	
	public Date beforeDate(Date coDate) {
		 long currTime=coDate.getTime() ; 
		 long oneDay =1000*60*60*24; 
		 long beforDayTime =currTime-oneDay ; 
		 coDate=new Date(beforDayTime );
		 return coDate;
	}
	
	@RequestMapping("search_daily_rate")
	public String searchRate (Model model,DailyRateM dailyRateM) {
		List<DRS> list=d.show(dailyRateM);
		Date date;
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
		Page page=new Page();
		page.setCount(9999);
		RateType rateType=new RateType();
		List<RateType> s=rate.list(page,rateType);
		model.addAttribute("s",s);
		RoomType roomType=new RoomType();
		page.setStart(0);
		List<RoomType> r=room.list(page, roomType);
		model.addAttribute("r",r);
		model.addAttribute("sum",sum);
		model.addAttribute("info",dailyRateM);
		return "listDailyRate";
	}
	
	@RequestMapping("listDailyR")
	public String listSearch(Model model) {
		Page page=new Page();
		page.setCount(9999);
		RateType rateType=new RateType();
		List<RateType> s=rate.list(page,rateType);
		model.addAttribute("s",s);
		RoomType roomType=new RoomType();
		page.setStart(0);
		List<RoomType> r=room.list(page, roomType);
		model.addAttribute("r",r);
		return "listDailyR";
	}
}
