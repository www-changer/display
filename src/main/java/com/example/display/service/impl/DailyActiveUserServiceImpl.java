package com.example.display.service.impl;

import com.example.display.mapper.DailyActiveUserMapper;
import com.example.display.model.DailyActiveUser;
import com.example.display.service.DailyActiveUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class DailyActiveUserServiceImpl implements DailyActiveUserService {

	@Autowired
	private DailyActiveUserMapper dailyActiveUserMapper;

	@Override
	public List<DailyActiveUser> selectAll() {
		Example example = new Example(DailyActiveUser.class);
		example.setOrderByClause("day");
		return dailyActiveUserMapper.selectByExample(example);
	}
}
