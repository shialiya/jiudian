package cn.scau;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.scau.page.Page;
import cn.scau.pojo.RateType;
import cn.scau.service.RateTypeService;

public class TestRateTypeService extends BaseTest {

	@Autowired
	RateTypeService r;
	
	@Test
	public void Testh () {
		RateType rateType=new RateType();
		Page page=new Page();
		rateType.setCode("B");
		 List<RateType> rateTypes=r.list(page, rateType);
		System.out.println("Hello"+rateTypes.get(0).getCode());
	}
}
