package cn.scau.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scau.dao.RateRuleMapper;
import cn.scau.dao.RateTypeMapper;
import cn.scau.page.Page;
import cn.scau.pojo.RateRule;
import cn.scau.pojo.RateRuleExample;
import cn.scau.pojo.RateRuleExample.Criteria;

@Service
public class RateRuleServiceImpl implements RateRuleService {

	@Autowired
	RateRuleMapper r;
	
	@Override
	public int total(RateRule rateRule) {
		// TODO Auto-generated method stub
		return r.total(rateRule);
	}

	@Override
	public List<RateRule> list(Page page, RateRule rateRule) {
		// TODO Auto-generated method stub
		return r.list(page, rateRule);
	}

	@Override
	public int add(RateRule rateRule) {
		// TODO Auto-generated method stub
		return r.insertSelective(rateRule);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return r.deleteByPrimaryKey(id);
	}

	@Override
	public RateRule get(Integer id) {
		// TODO Auto-generated method stub
		return r.selectByPrimaryKey(id);
	}

	@Override
	public int update(RateRule rateRule) {
		// TODO Auto-generated method stub
		return r.updateByPrimaryKeySelective(rateRule);
	}

	@Override
	public List<RateRule> search(RateRule rateRule) {
		RateRuleExample example=new RateRuleExample();
		Criteria criteria=example.createCriteria();
		if(!rateRule.getFromDate().toString().equals("2000-01-30"))
			criteria.andFromDateGreaterThanOrEqualTo(rateRule.getFromDate());
		if(!rateRule.getToDate().toString().equals("2000-01-30"))
			criteria.andToDateLessThanOrEqualTo(rateRule.getToDate());
		if(rateRule.getRateType().length()!=0)
			criteria.andRateTypeEqualTo(rateRule.getRateType());
		if(rateRule.getRmType().length()!=0)
			criteria.andRmTypeEqualTo(rateRule.getRmType());
		if(rateRule.getId()!=null)
			criteria.andIdEqualTo(rateRule.getId());
		List<RateRule> list=r.selectByExample(example);
		return list;
	}

}
