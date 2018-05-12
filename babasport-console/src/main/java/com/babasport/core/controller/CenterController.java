package com.babasport.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.babasport.core.bean.TestTb;
import com.babasport.core.service.TestTbService;

/**
 * 后台管理
 * @author xushy
 *
 */
@Controller
public class CenterController {
	
	@Autowired
	private TestTbService testTbService;
	//入口
	/**
	 * ModelAndView	：跳转视图+数据	不用
	 * void 		：异步时ajax
	 * String 		：跳转视图，Model携带数据
	 */
	@RequestMapping(value = "/test/index.do")
	public String index(Model model) {
		TestTb testTb = new TestTb();
		testTb.setName("abc");
		testTbService.insertTestTb(testTb);
		return "index";
	}
	
}
