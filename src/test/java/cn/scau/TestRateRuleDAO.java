package cn.scau;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.scau.dao.RateRuleMapper;
import cn.scau.page.Page;
import cn.scau.pojo.RateRule;

public class TestRateRuleDAO extends BaseTest {
	
	private static Logger logger=Logger.getLogger(TestRateRuleDAO.class);
	@Autowired
	private RateRuleMapper r;
	
	@Test
	public void raTest() throws Exception{
		Page page=new Page();
		RateRule rateRule=new RateRule();
		List<RateRule> list=r.list(page, rateRule);
		logger.info("hello"+list.get(0).getFromDate());
	}
	
}
