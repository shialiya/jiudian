package cn.scau.service;

import java.util.List;

import cn.scau.page.Page;
import cn.scau.pojo.RoomType;

public interface RoomTypeService {
	int total(RoomType roomType);
	List<RoomType> list(Page page,RoomType roomType);
	int add(RoomType roomType);
	int delete(String code);
	RoomType get(String code);
	int update(RoomType roomType);
}
