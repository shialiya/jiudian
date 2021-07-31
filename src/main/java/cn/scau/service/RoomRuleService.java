package cn.scau.service;

import java.util.List;

import cn.scau.page.Page;
import cn.scau.pojo.RoomRule;

public interface RoomRuleService {
	int total(RoomRule roomRule);
	List<RoomRule> list(Page page,RoomRule roomRule);
	int add(RoomRule roomRule);
	int delete(Integer id);
	RoomRule get(Integer id);
	int update(RoomRule roomRule);
	List<RoomRule> search(RoomRule roomRule);
}
