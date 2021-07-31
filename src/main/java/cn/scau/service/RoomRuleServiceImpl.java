package cn.scau.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scau.dao.RoomRuleMapper;
import cn.scau.page.Page;
import cn.scau.pojo.RoomRule;
import cn.scau.pojo.RoomRuleExample;
import cn.scau.pojo.RoomRuleExample.Criteria;
import cn.scau.pojo.RoomType;

@Service
public class RoomRuleServiceImpl implements RoomRuleService {

	@Autowired
	RoomRuleMapper r;
	
	@Override
	public int total(RoomRule roomRule) {
		// TODO Auto-generated method stub
		return r.total(roomRule);
	}

	@Override
	public List<RoomRule> list(Page page, RoomRule roomRule) {
		// TODO Auto-generated method stub
		return r.list(page, roomRule);
	}

	@Override
	public int add(RoomRule roomRule) {
		// TODO Auto-generated method stub
		return r.insertSelective(roomRule);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return r.deleteByPrimaryKey(id);
	}

	@Override
	public RoomRule get(Integer id) {
		// TODO Auto-generated method stub
		return r.selectByPrimaryKey(id);
	}

	@Override
	public int update(RoomRule roomRule) {
		// TODO Auto-generated method stub
		return r.updateByPrimaryKey(roomRule);
	}

	@Override
	public List<RoomRule> search(RoomRule roomRule) {
		RoomRuleExample example=new RoomRuleExample();
		Criteria criteria=example.createCriteria();
		if(roomRule.getId()!=null)
			criteria.andIdEqualTo(roomRule.getId());
		if(!roomRule.getFromDate().toString().equals("2000-01-30")) {
			criteria.andFromDateLessThanOrEqualTo(roomRule.getFromDate());
			criteria.andToDateGreaterThanOrEqualTo(roomRule.getFromDate());
		}
		if(roomRule.getRmType().length()!=0)
			criteria.andRmTypeEqualTo(roomRule.getRmType());
		List<RoomRule> list=r.selectByExample(example);
		return list;
	}

}
