package cn.scau.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scau.dao.DSMapper;
import cn.scau.pojo.DS;
import cn.scau.pojo.DSExample;
import cn.scau.pojo.DSExample.Criteria;

@Service
public class DSServiceImpl implements DSService {

	@Autowired
	DSMapper d;
	
	@Override
	public List<DS> list(Date fromDate, Date toDate, String rmType) {
		DSExample example=new DSExample();
		Criteria criteria=example.createCriteria();
		criteria.andDdateBetween(fromDate, toDate);
		criteria.andRmTypeEqualTo(rmType);
		List<DS> list=d.selectByExample(example);
		return list;
	}

}
