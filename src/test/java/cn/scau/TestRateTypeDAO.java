package cn.scau;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.scau.dao.RateTypeMapper;
import cn.scau.page.Page;
import cn.scau.pojo.RateType;

public class TestRateTypeDAO extends BaseTest {

	private static Logger logger=Logger.getLogger(TestRateTypeDAO.class);
	@Autowired
	private RateTypeMapper r;
	
	@Test
	public void rateTest()throws Exception{
		Page page=new Page();
		RateType rateType=new RateType();
		rateType.setCode("B");
		List<RateType> list=r.list(page, rateType);
		int i=r.total(rateType);
		logger.info("Hello"+i);
		
	}

}
