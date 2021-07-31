package cn.scau.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.stat.TableStat.Mode;

import cn.scau.page.Page;
import cn.scau.pojo.RoomType;
import cn.scau.service.RoomTypeService;

@Controller
@RequestMapping("")
public class RoomTypeController {
	
	@Autowired
	RoomTypeService roomTypeService;
	
	@RequestMapping("room_type_list")
	public String tolist(Model model,Page page) {
		RoomType roomType=new RoomType();
		List<RoomType> cs=roomTypeService.list(page,roomType);
		int total=roomTypeService.total(roomType);
		page.setTotal(total);
		model.addAttribute("cs",cs);
		model.addAttribute("page", page);
		model.addAttribute("total", total);
		return "listRoomType";
		
	}
	
	@RequestMapping("room_type_search")
	public String search(Model model,Page page,RoomType roomType) {
		List<RoomType> cs=roomTypeService.list(page, roomType);
		int total=roomTypeService.total(roomType);
		page.setTotal(total);
		model.addAttribute("cs",cs);
		model.addAttribute("page", page);
		model.addAttribute("total", total); 
		return "listRoomType";
	}
	
	@RequestMapping("room_type_add")
	public String add( Model model,RoomType roomType) {
		int j=1;
		try {
			roomTypeService.add(roomType);
		} catch (Exception e) {
			j=0;
		}
		model.addAttribute("j", j);
		return "addRoomType";
	}
	
	@RequestMapping("room_type_delete")
	public String delete(String code) {
		roomTypeService.delete(code);
		return "redirect:/room_type_list";
	}
	
	@RequestMapping("room_type_delete_group")
	public String deleteg(String[] codes) {
		for(int i=0;i<codes.length;i++) {
			roomTypeService.delete(codes[i]);
		}
		return "redirect:/room_type_list";
	}
	
	@RequestMapping("room_type_edit")
	public String edit(String code,Model model) throws IOException{
		RoomType r=roomTypeService.get(code);
		model.addAttribute("c", r);
		return "editRoomType";
	}
	
	@RequestMapping("room_type_update")
	public String update(Model model,RoomType r) {
		int j=1;
		try {
			roomTypeService.update(r);
		} catch (Exception e) {
			j=0;
		}
		model.addAttribute("j",j);
		return "editRoomType";
	}

}
