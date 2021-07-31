package cn.scau.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.stat.TableStat.Mode;

import cn.scau.page.Page;
import cn.scau.pojo.RateType;
import cn.scau.service.RateTypeService;

@Controller
@RequestMapping("")
public class RateTypeController {
	
	@Autowired
	RateTypeService rateTypeService;
	
	@RequestMapping("rate_type_list")
	public String tolist(Model model,Page page) {
		RateType rateType=new RateType();
		List<RateType> cs=rateTypeService.list(page,rateType);
		int total=rateTypeService.total(rateType);
		page.setTotal(total);
		model.addAttribute("cs",cs);
		model.addAttribute("page", page);
		model.addAttribute("total", total);
		return "listRateType";
		
	}
	
	@RequestMapping("rate_type_search")
	public String search(Model model,Page page,RateType rateType) {
		System.out.println("HELLO");
		System.out.println(rateType.getCode());
		System.out.println(rateType.getName());
		System.out.println(rateType.getDescription());
		System.out.println(rateType.getIsToAll());
		System.out.println("END");
		List<RateType> cs=rateTypeService.list(page, rateType);
		int total=rateTypeService.total(rateType);
		System.out.println(total);
		page.setTotal(total);
		model.addAttribute("cs",cs);
		model.addAttribute("page", page);
		model.addAttribute("total", total); 
		return "listRateType";
	}
	
	@RequestMapping("rate_type_add")
	public String add(Model model, RateType rateType) {
		int j=1;
		try {
					rateTypeService.add(rateType);

		} catch (Exception e) {
			j=0;// TODO: handle exception
		}
		model.addAttribute("j", j);
		return "addRoomType";	}
	
	@RequestMapping("rate_type_delete")
	public String delete(String code) {
		rateTypeService.delete(code);
		return "redirect:/rate_type_list";
	}
	
	@RequestMapping("rate_type_delete_group")
	public String deleteg(String[] codes) {
		System.out.println(codes);
		for(int i=0;i<codes.length;i++) {
			rateTypeService.delete(codes[i]);
		}
		return "redirect:/rate_type_list";
	}
	
	@RequestMapping("rate_type_edit")
	public String edit(String code,Model model) throws IOException{
		RateType r=rateTypeService.get(code);
		model.addAttribute("c", r);
		return "editRateType";
	}
	
	@RequestMapping("rate_type_update")
	public String update(Model model,RateType r) {
		int j=1;
		try {
					rateTypeService.update(r);

		} catch (Exception e) {
			j=0;// TODO: handle exception
		}
		model.addAttribute("j", j);
		return "addRoomType";
	}


}
