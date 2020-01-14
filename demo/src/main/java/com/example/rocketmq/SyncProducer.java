package com.example.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class SyncProducer {
    public static void main(String[] args) throws Exception {
        //Instantiate with a Producer group name.
        DefaultMQProducer producer = new DefaultMQProducer("please rename unique group name");
        producer.setNamesrvAddr("192.168.100.131:9876");
        //Launch the instance .
        producer.start();
        for (int i = 0; i < 100; i++) {
            //Create a Message instance, specifying Topic, tag and Message body.
            Message msg = new Message("TopicTest", "TagA", ("Hello RocketMQ" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            //Call send Message to deliver Message to one of brokers.
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
            //Shut down once the Producer instance is not longer in use.
            producer.shutdown();
        }
    }
}
