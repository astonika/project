package com.example.demo;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;

import com.rabbitmq.client.Channel;

//https://www.cnblogs.com/ASPNET2008/p/6414145.html

public class RabbitMQConfig {
	private String mqRabbitHost;
	private int mqRabbitPort;
	private String mqRabbitUserName;
	private String mqRabbitPassword;
	private String mqRabbitVirtualHost;
	public static final String EXCHANGE_NAME = "";
	public static final String QUEUE_NAME = null;
	public static final String ROUTING_KEY = null;

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(this.mqRabbitHost, this.mqRabbitPort);

		connectionFactory.setUsername(this.mqRabbitUserName);
		connectionFactory.setPassword(this.mqRabbitPassword);
		connectionFactory.setVirtualHost(this.mqRabbitVirtualHost);
		connectionFactory.setPublisherConfirms(true);

		return connectionFactory;
	}

	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		return template;
	}

	@Bean
	public DirectExchange defaultExchange() {
		return new DirectExchange(EXCHANGE_NAME);
	}

	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME, true);
	}

	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(defaultExchange()).with(ROUTING_KEY);
	}

	@Bean
	public SimpleMessageListenerContainer messageContainer() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
		container.setQueues(queue());
		container.setExposeListenerChannel(true);
		container.setMaxConcurrentConsumers(1);
		container.setConcurrentConsumers(1);
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
		container.setMessageListener(new ChannelAwareMessageListener() {

			@Override
			public void onMessage(Message message, Channel channel) throws Exception {
				byte[] body = message.getBody();
//				logger.info("消费端接收到消息 : " + new String(body));
				channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
			}
		});
		return container;
	}

}
