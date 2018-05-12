package com.babasport;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.babasport.core.bean.TestTb;
import com.babasport.core.dao.TestTbDao;
import com.babasport.core.service.TestTbService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml" })
public class TestTbTest {

	@Autowired
	private TestTbDao testTbDao;

	@Autowired
	TestTbService testTbService;

	@Test
	public void testAdd() throws Exception {
		TestTb testTb = new TestTb();
		testTb.setName("xushy1");
		testTb.setBirthday(new Date());
		testTbService.insertTestTb(testTb);
	}

}
