package com.aidian.middleware.bootstrap;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.project.service.UserService;

public class Consumer {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath*:spring-dubbo-consumer.xml" });
		context.start();
		UserService userService = context.getBean("userService", UserService.class); // 获取远程服务代理
		System.err.println("SSSSSSSSSSSSSSSSSSSSS  " + userService.signin("aa", "11"));
		;
		context.close();
	}
}
