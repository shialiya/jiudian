package cn.scau.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scau.pojo.Staff;
import cn.scau.pojo.StaffExample;
import cn.scau.pojo.StaffExample.Criteria;
import cn.scau.dao.StaffMapper;
import cn.scau.page.Page;

@Service
public class StaffImpl implements StaffService {

	@Autowired
	private StaffMapper sd;
	@Override
	public Staff login(String name, String pd) {
		// TODO Auto-generated method stub
		return sd.checkStaff(name, pd);
	}
	@Override
	public int total(Staff staff) {
		// TODO Auto-generated method stub
		return sd.total(staff);
	}
	@Override
	public List<Staff> list(Page page, Staff staff) {
		// TODO Auto-generated method stub
		return sd.list(page, staff);
	}
	@Override
	public int add(Staff staff) {
		// TODO Auto-generated method stub
		return sd.insertSelective(staff);
	}
	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return sd.deleteByPrimaryKey(id);
	}
	@Override
	public Staff get(Integer id) {
		// TODO Auto-generated method stub
		return sd.selectByPrimaryKey(id);
	}
	@Override
	public int update(Staff staff) {
		// TODO Auto-generated method stub
		return sd.updateByPrimaryKey(staff);
	}
	@Override
	public List<Staff> search(Staff staff) {
		StaffExample example=new StaffExample();
		Criteria criteria=example.createCriteria();
		if(staff.getId()!=null)
			criteria.andIdEqualTo(staff.getId());
		if(staff.getDept().length()!=0)
			criteria.andDeptEqualTo(staff.getDept());
		if(staff.getName().length()!=0)
			criteria.andNameEqualTo(staff.getName());
		if(staff.getSurname().length()!=0)
			criteria.andSurnameEqualTo(staff.getSurname());
		if(staff.getPosition().length()!=0)
			criteria.andPositionEqualTo(staff.getPosition());
		List<Staff> list=sd.selectByExample(example);
		return list;
	}

}
