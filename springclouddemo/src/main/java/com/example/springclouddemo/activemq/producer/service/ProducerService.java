package com.example.springclouddemo.activemq.producer.service;

import javax.jms.Destination;

public interface ProducerService {

	void sendMessage(String message);

	void sendMessage(Destination destination, String message);

}
