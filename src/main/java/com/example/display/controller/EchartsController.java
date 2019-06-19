package com.example.display.controller;

import com.example.display.model.DailyActiveUser;
import com.example.display.model.DailyRetainedUserRate;
import com.example.display.service.DailyActiveUserService;
import com.example.display.service.DailyRetainedUserRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class EchartsController {


	@Autowired
	private DailyActiveUserService dailyActiveUserService;

	@Autowired
	private DailyRetainedUserRateService dailyRetainedUserRateService;

	@RequestMapping(value = "/getDAU")
	@ResponseBody
	public List<DailyActiveUser> getDAU() {
		return dailyActiveUserService.selectAll();
	}

	@RequestMapping(value = "/getDNUR")
	@ResponseBody
	public List<DailyRetainedUserRate> showDNUR() {
		return dailyRetainedUserRateService.selectAll();
	}

	@RequestMapping(value = "/showDAU")
	public ModelAndView showFAU() {
		return new ModelAndView("dau");
	}

	@RequestMapping(value = "/showDNUR")
	public ModelAndView showFNUR() {
		return new ModelAndView("dnur");
	}

}
