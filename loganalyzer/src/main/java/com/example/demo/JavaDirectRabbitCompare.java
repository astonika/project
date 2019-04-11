package com.example.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;

import kafka.serializer.StringDecoder;
import scala.Tuple2;

public class JavaDirectRabbitCompare {
	public static void main(String[] args) throws Exception {
		/**
		 * setMaster("local[2]")，至少要指定两个线程，一条用于用于接收消息，一条线程用于处理消息 Durations.seconds(2)每两秒读取一次kafka
		 */
		SparkConf sparkConf = new SparkConf().setAppName("JavaDirectKafkaWordCount").setMaster("local[2]");
		JavaStreamingContext jssc = new JavaStreamingContext(sparkConf, Durations.seconds(2));
		/**
		 * checkpoint("hdfs://192.168.168.200:9000/checkpoint")防止数据丢包
		 */
		jssc.checkpoint("hdfs://192.168.168.200:9000/checkpoint");
		/**
		 * 配置连接kafka的相关参数
		 */
		Set<String> topicsSet = new HashSet<>(Arrays.asList("test"));
		Map<String, String> kafkaParams = new HashMap<>();
		kafkaParams.put("metadata.broker.list", "192.168.168.200:9092");

		// Create direct kafka stream with brokers and topics
		JavaPairInputDStream<String, String> messages = KafkaUtils.createDirectStream(jssc, String.class, String.class, StringDecoder.class, StringDecoder.class, kafkaParams,
				topicsSet);

		// Get the lines, split them into words, count the words and print
		/**
		 * _2()获取第二个对象的值
		 */
		JavaDStream<String> lines = messages.map(new Function<Tuple2<String, String>, String>() {
			@Override
			public String call(Tuple2<String, String> tuple2) {
				return tuple2._2();
			}
		});

		String sfzh = "432922196105276721";
		JavaDStream<String> wordCounts = lines.filter(new Function<String, Boolean>() {
			@Override
			public Boolean call(String s) throws Exception {
// TODO Auto-generated method stub
				/**
				 * 通过身份证号筛选出相关数据
				 */
				if (s.contains(sfzh)) {
					System.out.println("比对出来的结果：" + s);
					return true;
				}
				return false;
			}
		});
		wordCounts.print();
		// Start the computation
		jssc.start();
		jssc.awaitTermination();
	}

}
