package cn.scau.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scau.dao.RateTypeMapper;
import cn.scau.page.Page;
import cn.scau.pojo.RateType;

@Service
public class RateTypeServiceImpl implements RateTypeService {

	@Autowired
	RateTypeMapper r;
	
	@Override
	public int total(RateType rateType) {
		// TODO Auto-generated method stub
		return r.total(rateType);
	}

	@Override
	public List<RateType> list(Page page, RateType rateType) {
		// TODO Auto-generated method stub
		return r.list(page, rateType);
	}

	@Override
	public int add(RateType rateType) {
		// TODO Auto-generated method stub
		return r.insertSelective(rateType);
	}

	@Override
	public int delete(String code) {
		// TODO Auto-generated method stub
		return r.deleteByPrimaryKey(code);
	}

	@Override
	public RateType get(String code) {
		// TODO Auto-generated method stub
		return r.selectByPrimaryKey(code);
	}

	@Override
	public int update(RateType rateType) {
		// TODO Auto-generated method stub
		return r.updateByPrimaryKey(rateType);
	}

}
