package cn.scau.web;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.scau.page.Page;
import cn.scau.pojo.DS;
import cn.scau.pojo.RateType;
import cn.scau.pojo.RoomType;
import cn.scau.service.DSService;
import cn.scau.service.RoomTypeService;

@Controller
@RequestMapping("")
public class DailyStatusController {

	@Autowired
	DSService d;
	@Autowired
	RoomTypeService room;
	
	@RequestMapping("list_DS")
	public String preList(Model model) {
		Page page=new Page();
		page.setCount(9999);
		RoomType roomType=new RoomType();
		List<RoomType> r=room.list(page, roomType);
		model.addAttribute("r",r);
		return "listDailyStatus";
	}
	
	@RequestMapping("list_DS_search")
	public String toList(Model model, Date fromDate, Date toDate, String rmType) {
		List<DS> list=d.list(fromDate, toDate, rmType);
		model.addAttribute("list", list);
		Page page=new Page();
		page.setCount(9999);
		RoomType roomType=new RoomType();
		List<RoomType> r=room.list(page, roomType);
		model.addAttribute("r",r);
		return "listDailyStatus";
	}
}
