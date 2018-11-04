package com.company.project.bootstrap;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "classpath*:spring-context.xml" });
		context.start();
		System.out.println("服务已经启动...");
		System.in.read(); // 按任意键退出
	}
}