package cn.scau.service;

import java.util.List;

import cn.scau.page.Page;
import cn.scau.pojo.RateType;

public interface RateTypeService {
	int total(RateType rateType);
	List<RateType> list(Page page,RateType rateType);
	int add(RateType rateType);
	int delete(String code);
	RateType get(String code);
	int update(RateType rateType);
}
