package com.aidian.middleware.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableCaching
@SpringBootApplication
//@EnableDubboConfiguration
public class NovelMiddlewareProviderApplication {
	// 使用jar方式打包的启动方式
//	private static CountDownLatch countDownLatch = new CountDownLatch(1);

	public static void main(String[] args) throws Exception {
		// Prevent to get IPV6 address,this way only work in debug mode
		// But you can pass use -Djava.net.preferIPv4Stack=true,then it work well
		// whether in debug mode or not
//        System.setProperty("java.net.preferIPv4Stack", "true");
		SpringApplication.run(NovelMiddlewareProviderApplication.class, args);
//		SpringApplication.run(NovelMiddlewareProviderApplication.class, args).registerShutdownHook();
//		countDownLatch.await();

//		new EmbeddedZooKeeper(2181, false).start(); // #1
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//				ProviderConfiguration.class); // #2
//		context.start(); // #3
//		System.in.read(); // #4
	}

}
