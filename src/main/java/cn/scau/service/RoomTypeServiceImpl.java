package cn.scau.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scau.dao.RoomTypeMapper;
import cn.scau.page.Page;
import cn.scau.pojo.RoomType;
import cn.scau.pojo.Staff;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

	@Autowired
	RoomTypeMapper r;
	
	@Override
	public List<RoomType> list(Page page,RoomType roomType){
		return r.list(page,roomType);
	}
	
	@Override
	public int total(RoomType roomType) {
		return r.total(roomType);
	}
	
	@Override
	public int add(RoomType roomType) {
		int i=0;
		i=r.insertSelective(roomType);
		return i;
	}
	
	@Override
	public int delete(String code) {
		int i=0;
		i=r.deleteByPrimaryKey(code);
		return i;
	}
	
	@Override
	public RoomType get(String code) {
		return r.selectByPrimaryKey(code);
	}
	
	@Override
	public int update(RoomType roomType) {
		
		return r.updateByPrimaryKeySelective(roomType);
	}
}
