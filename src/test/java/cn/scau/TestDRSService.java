package cn.scau;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.scau.pojo.DRS;
import cn.scau.pojo.DailyRateM;
import cn.scau.service.DRSService;
import cn.scau.service.DRSServiceImpl;

public class TestDRSService extends BaseTest {

	@Autowired
	DRSService d;
	
	@Test
	public void test() {
		DailyRateM dm = new DailyRateM();
		Date ciDate=new Date(118, 7, 1);
		Date coDate=new Date(118, 7, 9);
		dm.setCiDate(ciDate);
		dm.setCoDate(coDate);
		dm.setRest(1);
		dm.setRateType("P1B");
		dm.setRmType("SPK");
		List<DRS> list=d.show(dm);
		for(int i=0;i<list.size();i++){
		System.out.println(list.get(i).getDdate()+" "+list.get(i).getRate()+" "+list.get(i).getRest());
		
	}
	}}
