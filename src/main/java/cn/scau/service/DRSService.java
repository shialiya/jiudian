package cn.scau.service;

import java.util.List;

import cn.scau.pojo.DRS;
import cn.scau.pojo.DailyRateM;

public interface DRSService {
	List<DRS> show(DailyRateM dailyRateM);
}
