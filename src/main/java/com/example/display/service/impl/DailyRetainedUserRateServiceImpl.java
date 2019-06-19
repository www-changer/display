package com.example.display.service.impl;

import com.example.display.mapper.DailyRetainedUserRateMapper;
import com.example.display.model.DailyRetainedUserRate;
import com.example.display.service.DailyRetainedUserRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class DailyRetainedUserRateServiceImpl implements DailyRetainedUserRateService {

	@Autowired
	private DailyRetainedUserRateMapper dailyRetainedUserRateMapper;

	@Override
	public List<DailyRetainedUserRate> selectAll() {
		Example example = new Example(DailyRetainedUserRate.class);
		example.setOrderByClause("day");
		return dailyRetainedUserRateMapper.selectByExample(example);
	}
}

