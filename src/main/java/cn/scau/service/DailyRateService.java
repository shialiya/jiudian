package cn.scau.service;

import java.sql.Date;
import java.util.List;

import cn.scau.pojo.DailyRateM;

public interface DailyRateService {

	List<DailyRateM> list(Date fromDate, Date toDate, String room, String rat);
}
