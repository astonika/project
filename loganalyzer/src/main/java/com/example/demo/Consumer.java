package com.example.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

//https://blog.csdn.net/qq_34021712/article/details/72567801
//https://blog.csdn.net/hao134838/article/details/71698756

public class Consumer {

	private final static String QUEUE_NAME = "workbench_log_save_operation_queue";

	public static void main(String[] argv) throws Exception {

		// 获取到连接以及mq通道
		Connection connection = ConnectionUtil.getConnection();
		// 从连接中创建通道
		Channel channel = connection.createChannel();

		// 声明队列(如果你已经明确的知道有这个队列,那么下面这句代码可以注释掉,如果不注释掉的话,也可以理解为消费者必须监听一个队列,如果没有就创建一个)
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		channel.basicQos(1);
		// 定义队列的消费者
		QueueingConsumer consumer = new QueueingConsumer(channel);
		/*
		 * 监听队列 参数1:队列名称 参数2：是否发送ack包，不发送ack消息会持续在服务端保存，直到收到ack。 可以通过channel.basicAck手动回复ack 参数3：消费者
		 */
		channel.basicConsume(QUEUE_NAME, false, consumer);

		// 获取消息
//		while (true) {
//			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
//			String message = new String(delivery.getBody());
//			System.out.println(" [消费者] Received '" + message + "'");
//		}
		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			System.out.println(" [x] Received '" + message + "'");
			// 休眠
			Thread.sleep(10);
			// 返回确认状态
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
		}
	}
}