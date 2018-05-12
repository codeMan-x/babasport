package com.babasport.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.babasport.core.bean.TestTb;
import com.babasport.core.dao.TestTbDao;

/**
 * 测试
 * @author xushy
 *
 */
@Service("testTbService")
@Transactional
public class TestTbServiceImpl implements TestTbService {
	
	@Autowired
	private TestTbDao testTbDao;
	
	// @Transactional(readOnly=true)
	public void insertTestTb(TestTb testTb) {
		testTbDao.insertTestTb(testTb);
		
		// throw new RuntimeException();
	}
}
