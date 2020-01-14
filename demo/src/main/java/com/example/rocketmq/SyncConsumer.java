package com.example.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

public class SyncConsumer {
    public static void main(String[] args) throws Exception {
        /*
         * Instantiate with specified Consumer group name.
         */
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("please rename to unique group name ");
        /*
         * Specify name server addresses.
         */
        consumer.setNamesrvAddr("192.168.249.47:9876");
        /*
         * Specify where to start case the specifed Consumer group is a brand new one .
         */
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        // consumer.setMessageModel(MessageModel.BROADCASTING);
        /*
         * Subscribe one more more Topics to consume.
         */
        consumer.subscribe("TopicTest", "*");
        /*
         * Register callback to execute on arrival of Messages fetched from brokers.
         */
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt>
                                                                    msgs, ConsumeConcurrentlyContext context) {
                System.out.printf(Thread.currentThread().getName() + "Receive_New_Messages: " + msgs + "%n");
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        /*
         * Launch the Consumer instance.
         */
        consumer.start();
    }
}
