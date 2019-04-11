package com.example.demo;

import java.util.Arrays;
import java.util.Iterator;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

import scala.Tuple2;

//https://www.cnblogs.com/luoxuehuan/p/5476859.html
//https://www.cnblogs.com/xzzq/p/7240736.html
//@SpringBootApplication
public class LoganalyzerApplication {

	public static void main(String[] args) throws Exception {
//		SpringApplication.run(LoganalyzerApplication.class, args);
		SparkConf conf = new SparkConf().setMaster("spark：//Master:7077").setAppName("wordCountOnline");
		JavaStreamingContext jsc = new JavaStreamingContext(conf, Durations.seconds(5));
		JavaReceiverInputDStream<String> lines = jsc.socketTextStream("Master", 9999);

		JavaDStream<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Iterator<String> call(String line) throws Exception {
				return Arrays.asList(line.split(" ")).iterator();
			}
		});

		JavaPairDStream<String, Integer> pairs = words.mapToPair(new PairFunction<String, String, Integer>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Tuple2<String, Integer> call(String word) throws Exception {
				return new Tuple2<String, Integer>(word, 1);
			}
		});

		JavaPairDStream<String, Integer> wordsCount = pairs.reduceByKey(new Function2<Integer, Integer, Integer>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Integer call(Integer v1, Integer v2) throws Exception {
				return v1 + v2;
			}
		});

		wordsCount.print();

		jsc.start();

		jsc.awaitTermination();
		jsc.close();
	}

}
