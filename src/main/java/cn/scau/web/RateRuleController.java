package cn.scau.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.scau.page.Page;
import cn.scau.pojo.RateRule;
import cn.scau.pojo.RateType;
import cn.scau.pojo.RoomType;
import cn.scau.service.RateRuleService;
import cn.scau.service.RateTypeService;
import cn.scau.service.RoomTypeService;

@Controller
@RequestMapping("")
public class RateRuleController {
	@Autowired
	RateRuleService r;
	@Autowired
	RateTypeService rate;
	@Autowired
	RoomTypeService room;
	
	@RequestMapping("rate_rule_list")
	public String tolist(Model model,Page page) {
		RateRule rateRule=new RateRule();
		List<RateRule> cs=r.list(page, rateRule);
		int total=r.total(rateRule);
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
		return "listRateRule";
	}
	
	@RequestMapping("rate_rule_search")
	public String search(Model model,RateRule rateRule,Page page) {
		List<RateRule> list=r.search(rateRule);
		model.addAttribute("cs", list);
		int total=list.size();
		page.setTotal(total);
		page.setCount(9999);
		model.addAttribute("page",page);
		model.addAttribute("total", total);
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
		return "listRateRule";
	}
	
	@RequestMapping("show_rate_rule_add")
	public String showAdd(Model model) {
		Page page=new Page();
		page.setCount(9999);
		RateType rateType=new RateType();
		List<RateType> s=rate.list(page,rateType);
		model.addAttribute("s",s);
		RoomType roomType=new RoomType();
		page.setStart(0);
		List<RoomType> r=room.list(page, roomType);
		model.addAttribute("r",r);
		return "addRateRule";
	}
	
	@RequestMapping("rate_rule_add")
	public String add(Model model,RateRule rateRule) {
		int j=1;
		try {
			r.add(rateRule);

		} catch (Exception e) {
			j=0;
		}
		model.addAttribute("j", j);
		return "addRateRule";
	}
	
	@RequestMapping("rate_rule_delete")
	public String delete(Integer id) {
		r.delete(id);
		return "redirect:/rate_rule_list";
	}
	
	@RequestMapping("rate_rule_delete_group")
	public String deleteg(Integer[] ids) {
		for(int i=0;i<ids.length;i++) {
			System.out.println(ids[i]);
			r.delete(ids[i]);}
		return "redirect:/rate_rule_list";
	}
	
	@RequestMapping("rate_rule_edit")
	public String edit(Integer id,Model model) {
		RateRule rateRule=r.get(id);
		model.addAttribute("c",rateRule);
		Page page=new Page();
		page.setCount(9999);
		RateType rateType=new RateType();
		List<RateType> s=rate.list(page,rateType);
		model.addAttribute("s",s);
		RoomType roomType=new RoomType();
		page.setStart(0);
		List<RoomType> r=room.list(page, roomType);
		model.addAttribute("r",r);
		return "editRateRule";
	}
	
	@RequestMapping("rate_rule_update")
	public String update(Model model,RateRule rateRule) {
		int j=1;
		if (rateRule.getMon()==null) rateRule.setMon(false); 
		if (rateRule.getTue()==null) rateRule.setTue(false); 
		if (rateRule.getWed()==null) rateRule.setWed(false); 
		if (rateRule.getThu()==null) rateRule.setThu(false); 
		if (rateRule.getFri()==null) rateRule.setFri(false); 
		if (rateRule.getSat()==null) rateRule.setSat(false); 
		if (rateRule.getSun()==null) rateRule.setSun(false); 
		try {
			r.update(rateRule);
		} catch (Exception e) {
			j=0;
		}
		model.addAttribute("j", j);
		return "editRateRule";
	}
}
