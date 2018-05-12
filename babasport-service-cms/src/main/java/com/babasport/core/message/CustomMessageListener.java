package com.babasport.core.message;

import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;

import com.babasport.core.service.solr.SearchService;
import com.babasport.core.service.staticpage.StaticPageService;

/**
 * 处理类
 * 
 * @author xushy
 *
 */
public class CustomMessageListener implements MessageListener {

	@Autowired
	private StaticPageService staticPageService;
	@Override
	public void onMessage(Message message) {
		ActiveMQTextMessage aMessage = (ActiveMQTextMessage) message;
		try {
			// System.out.println("ActiveMQ中的消息是cms：" + aMessage.getText());
			// 处理：静态化页面
			String id = aMessage.getText();
			// 数据
			Map<String, Object> root = new HashMap<>();
			// 将页面中放到model中的动态数据添加到root中
			staticPageService.productStaticPage(root, id);

		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
