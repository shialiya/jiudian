package cn.scau.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scau.dao.DailyRateMapper;
import cn.scau.pojo.DailyRateM;

@Service
public class DailyRateServiceImpl implements DailyRateService {

	@Autowired
	DailyRateMapper d;
	@Override
	public List<DailyRateM> list(Date fromDate, Date toDate, String room, String rat) {
		// TODO Auto-generated method stub
		return d.list(fromDate, toDate, room, rat);
	}

}
