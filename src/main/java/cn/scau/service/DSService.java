package cn.scau.service;

import java.sql.Date;
import java.util.List;

import cn.scau.pojo.DS;

public interface DSService {

	List<DS> list(Date fromDate, Date toDate, String rmType);
}
