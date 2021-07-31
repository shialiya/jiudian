package cn.scau.web;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.scau.page.Page;
import cn.scau.pojo.Staff;
import cn.scau.service.StaffService;

@Controller
@RequestMapping("")
public class StaffLoginController {
	private static Logger logger=Logger.getLogger(StaffLoginController.class);
	
	@Autowired
	private StaffService staffService;
	
	@RequestMapping("login")
	public String login(Model model,String id, String pd) {
		System.out.println(id+pd);
		Staff staff=staffService.login(id, pd);
		ModelAndView mv=null;
		int j=0;
		if(staff !=null) {
			model.addAttribute("staff",staff);
			model.addAttribute("power",1);
			return "main";
		}
		else {
			j=1;
		}
			model.addAttribute("j", j);
			return "login";
		
	}
	
	@RequestMapping("index")
	public String index() {
		return "login";
	}

	
	@RequestMapping("staff_list")
	public String tolist(Model model,Page page) {
		Staff staff=new Staff();
		List<Staff> cs=staffService.list(page,staff);
		int total=staffService.total(staff);
		page.setTotal(total);
		model.addAttribute("cs",cs);
		model.addAttribute("page", page);
		model.addAttribute("total", total);
		model.addAttribute("sear", 1);
		return "listStaff";
		
	}
	
	
	
	@RequestMapping("staff_search")
	public String search(Model model,Staff staff) {
		List<Staff> cs=staffService.search(staff);
		int total=cs.size();
		Page page=new Page();
		page.setCount(9999);
		page.setTotal(total);
		page.setStart(0);
		model.addAttribute("cs",cs);
		model.addAttribute("page", page);
		model.addAttribute("total", total); 
		return "listStaff";
	}
	
	@RequestMapping("staff_person")
	public String showPerson(Integer id,Model model) {
		Staff r=staffService.get(id);
		model.addAttribute("c", r);
		return "showPerson";
	}
	
	@RequestMapping("staff_add")
	public String add(Model model, Staff staff) {
		int j=1;
		try {
					staffService.add(staff);

		} catch (Exception e) {
			j=0;// TODO: handle exception
		}
		
		model.addAttribute("j", j);
		return "addRoomType";
	}
	
	@RequestMapping("staff_delete")
	public String delete(Integer id) {
		staffService.delete(id);
		return "redirect:/staff_list";
	}
	
	@RequestMapping("staff_delete_group")
	public String deleteg(Integer[] id) {
		System.out.println(id);
		for(int i=0;i<id.length;i++) {
			staffService.delete(id[i]);
		}
		return "redirect:/staff_list";
	}
	
	@RequestMapping("staff_edit")
	public String edit(Integer id,Model model) throws IOException{
		Staff r=staffService.get(id);
		model.addAttribute("c", r);
		return "editStaff";
	}
	
	@RequestMapping("staff_update")
	public String update(Model model,Staff r) {
		int j=1;
		try {
					staffService.update(r);

		} catch (Exception e) {
			j=0;// TODO: handle exception
		}
		model.addAttribute("j", j);
		return "addRoomType";
	}

}
