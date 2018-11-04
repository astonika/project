package com.aidian.middleware.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@SpringBootApplication(scanBasePackages = "com.aidian.middleware.controller")
public class NovelMiddlewareConsumerApplication {

	public static void main(String[] args) {
		// Prevent to get IPV6 address,this way only work in debug mode
		// But you can pass use -Djava.net.preferIPv4Stack=true,then it work well
		// whether in debug mode or not
//		System.setProperty("java.net.preferIPv4Stack", "true");
		SpringApplication.run(NovelMiddlewareConsumerApplication.class, args);
		
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
//        context.start();
//        GreetingServiceConsumer greetingServiceConsumer = context.getBean(GreetingServiceConsumer.class);
//        String hello = greetingServiceConsumer.doSayHello("configuration");
//        System.out.println("result: " + hello);
	}

}
