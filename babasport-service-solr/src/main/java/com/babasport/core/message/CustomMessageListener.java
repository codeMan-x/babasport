package com.babasport.core.message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;

import com.babasport.core.service.solr.SearchService;

/**
 * 处理类
 * 
 * @author xushy
 *
 */
public class CustomMessageListener implements MessageListener {

	@Autowired
	private SearchService searchService;

	@Override
	public void onMessage(Message message) {
		ActiveMQTextMessage aMessage = (ActiveMQTextMessage) message;
		try {
			// System.out.println("ActiveMQ中的消息是：" + aMessage.getText());
			// 处理：保存商品信息到solr服务器
			searchService.insertProductToSolr(Long.parseLong(aMessage.getText()));
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
