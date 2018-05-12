package com.babasport.core.service.staticpage;

import java.util.Map;

public interface StaticPageService {
	// 静态化商品 ActiveMQ发送过来的id
	public void productStaticPage(Map<String, Object> root, String id);
}
