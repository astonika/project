package com.example.demo;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
//@Log4j
@Slf4j
public class ProductServiceImpl extends BaseService implements ProductService, RabbitTemplate.ConfirmCallback {

	@Autowired
	private ProductMapper productMapper;

	private RabbitTemplate rabbitTemplate;

	public ProductServiceImpl(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
		this.rabbitTemplate.setConfirmCallback(this);
	}

	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//		this.logger.info(" 消息id:" + correlationData);
		if (ack) {
//			this.logger.info("消息发送确认成功");
		} else {
//			this.logger.info("消息发送确认失败:" + cause);

		}
	}

	@Override
	public void save(Product product) {

		// 执行保存
		String uuid = UUID.randomUUID().toString();
		CorrelationData correlationId = new CorrelationData(uuid);
		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, product.getName(), correlationId);
	}
}
