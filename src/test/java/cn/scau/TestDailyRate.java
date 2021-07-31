package cn.scau;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.scau.dao.DailyRateMapper;
import cn.scau.pojo.DailyRateM;

public class TestDailyRate extends BaseTest {
	private static Logger logger=Logger.getLogger(TestDailyRate.class);

	@Autowired
	DailyRateMapper d;
	
	@Test
	public void test() throws Exception{
		List<DailyRateM> list;
		Date fromDate=new Date(((java.util.Date) new SimpleDateFormat("ddMMyyyy").parse("01082018")).getTime());
		Date toDate=new Date(((java.util.Date) new SimpleDateFormat("ddMMyyyy").parse("03082018")).getTime());
//		list=d.list(fromDate,toDate,"DLT", "B1B");
		logger.info((toDate.getTime()-fromDate.getTime())/(3600*24*1000));
	}
}
