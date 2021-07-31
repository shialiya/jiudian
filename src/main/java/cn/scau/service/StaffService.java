package cn.scau.service;

import java.util.List;

import cn.scau.page.Page;
import cn.scau.pojo.Staff;

public interface StaffService {

	public Staff login(String id, String pd);
	int total(Staff staff);
	List<Staff> list(Page page,Staff staff);
	int add(Staff staff);
	int delete(Integer id);
	Staff get(Integer id);
	int update(Staff staff);
	List<Staff> search(Staff staff);
}
