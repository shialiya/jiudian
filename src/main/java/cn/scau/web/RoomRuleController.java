package cn.scau.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.scau.page.Page;
import cn.scau.pojo.RateType;
import cn.scau.pojo.RoomRule;
import cn.scau.pojo.RoomType;
import cn.scau.pojo.RoomType;
import cn.scau.service.RoomTypeService;
import cn.scau.service.RoomRuleService;
import cn.scau.service.RoomTypeService;

@Controller
@RequestMapping("")
public class RoomRuleController {
	@Autowired
	RoomRuleService r;
	
	@Autowired
	RoomTypeService room;
	
	
	@RequestMapping("room_rule_list")
	public String tolist(Model model,Page page) {
		RoomRule roomRule=new RoomRule();
		List<RoomRule> cs=r.list(page, roomRule);
		int total=r.total(roomRule);
		page.setTotal(total);
		model.addAttribute("cs",cs);
		model.addAttribute("page",page);
		model.addAttribute("total",total);
		Page page1=new Page();
		page1.setCount(9999);
		page1.setStart(0);
		RoomType roomType=new RoomType();
		List<RoomType> r=room.list(page1, roomType);
		model.addAttribute("r",r);
		model.addAttribute("sear", 1);
		return "listRoomRule";
	}
	
	@RequestMapping("show_room_rule_add")
	public String showAdd(Model model) {
		Page page=new Page();
		page.setCount(9999);
		RoomType roomType=new RoomType();
		List<RoomType> s=room.list(page,roomType);
		model.addAttribute("s",s);
		return "addRoomRule";
	}
	
	@RequestMapping("room_rule_add")
	public String add(Model model,RoomRule roomRule) {
		int j=1;
		try {
			r.add(roomRule);

		} catch (Exception e) {
			// TODO: handle exception
			j=0;
		}
		model.addAttribute("j", j);
		return "addRoomType";
	}
	
	@RequestMapping("room_rule_delete")
	public String delete(Integer id) {
		r.delete(id);
		return "redirect:/room_rule_list";
	}
	
	@RequestMapping("room_rule_delete_group")
	public String deleteg(Integer[] ids) {
		for(int i=0;i<ids.length;i++) {
			System.out.println(ids[i]);
			r.delete(ids[i]);}
		return "redirect:/room_rule_list";
	}
	
	@RequestMapping("room_rule_edit")
	public String edit(Integer id,Model model) {
		RoomRule roomRule=r.get(id);
		model.addAttribute("c",roomRule);
		Page page=new Page();
		page.setCount(9999);
		RoomType roomType=new RoomType();
		List<RoomType> s=room.list(page,roomType);
		model.addAttribute("s",s);
		return "editRoomRule";
	}
	
	@RequestMapping("room_rule_search")
	public String search(RoomRule roomRule,Model model) {
		List<RoomRule> list=r.search(roomRule);
		int total=r.total(roomRule);
		Page page=new Page();
		page.setCount(9999);
		page.setTotal(total);
		model.addAttribute("cs",list);
		model.addAttribute("page",page);
		model.addAttribute("total",total);
		Page page1=new Page();
		page1.setCount(9999);
		page1.setStart(0);
		RoomType roomType=new RoomType();
		List<RoomType> r=room.list(page1, roomType);
		model.addAttribute("r",r);
		return "listRoomRule";
	}
	
	@RequestMapping("room_rule_update")
	public String update(Model model,RoomRule roomRule) {
		int j=1;
		try {
			r.update(roomRule);

		} catch (Exception e) {
			// TODO: handle exception
			j=0;
		}
		model.addAttribute("j", j);
		return "addRoomType";
	}

}
