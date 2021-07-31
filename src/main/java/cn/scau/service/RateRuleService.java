package cn.scau.service;

import java.util.List;

import cn.scau.page.Page;
import cn.scau.pojo.RateRule;

public interface RateRuleService {
	int total(RateRule rateRule);
	List<RateRule> list(Page page,RateRule rateRule);
	int add(RateRule rateRule);
	int delete(Integer id);
	RateRule get(Integer id);
	int update(RateRule rateRule);
	List<RateRule> search(RateRule rateRule);
}
