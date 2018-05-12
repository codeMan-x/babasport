package com.babasport.core.service.product;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class ProductServiceImpl {
	@Autowired
	private JmsTemplate jmsTemplate;

	// 上架商品
	public void isShow(Long[] ids) {

		for (final Long id : ids) {
			// 商品状态变更
			// 发送消息到ActiveMQ中
			jmsTemplate.send(new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
					// session携带消息(object、map、text)
					return session.createTextMessage(String.valueOf(id));
				}
			});
		}
	}
}
