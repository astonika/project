package com.example.springclouddemo.activemq.producer.service.impl;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.example.springclouddemo.activemq.producer.service.ProducerService;

@Service
public class ProducerServiceImpl implements ProducerService {

	// @Autowired
	@Resource
	private JmsTemplate jmsTemplate;

	@Override
	public void sendMessage(final String message) {
		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}

	@Override
	public void sendMessage(Destination destination, final String message) {
		System.err.println(jmsTemplate.getClass());
		jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}
}
