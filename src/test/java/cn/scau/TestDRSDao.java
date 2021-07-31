package cn.scau;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.scau.dao.DRSMapper;
import cn.scau.pojo.DRS;
import cn.scau.pojo.DRSExample;
import cn.scau.pojo.DRSExample.Criteria;
import cn.scau.pojo.DRSExample.Criterion;

public class TestDRSDao extends BaseTest {

	private static Logger logger=Logger.getLogger(TestDRSDao.class);
	
	@Autowired
	DRSMapper drsMapper;
	
	@Test public void test() throws Exception{
		
		DRSExample example=new DRSExample();
		Criteria criteria=example.createCriteria();
		criteria.andRmTypeEqualTo("SPK");
		criteria.andRateTypeEqualTo("B1B");
		criteria.andRestGreaterThanOrEqualTo(5);
		List<DRS> list=drsMapper.selectByExample(example);
//		for(int i=0;i<list.size();i++)
		logger.info(list.size());
	}
}
