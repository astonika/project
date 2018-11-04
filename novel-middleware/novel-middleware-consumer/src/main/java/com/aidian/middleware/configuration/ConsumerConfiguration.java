/**
 * 
 */
package com.aidian.middleware.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

/**
 * @author cdz
 *
 */
//@Configuration
//@EnableDubbo(scanBasePackages = "com.aidian.middleware.service")
//@PropertySource("classpath:/spring/dubbo-consumer.properties")
//@ComponentScan(value = { "com.aidian.middleware.controller" })
public class ConsumerConfiguration {

//	@Bean
//	public ApplicationConfig applicationConfig() {
//		ApplicationConfig applicationConfig = new ApplicationConfig();
//		applicationConfig.setName("novel-middleware-consumer");
//		return applicationConfig;
//	}

//	@Bean
//	public RegistryConfig registryConfig() {
//		RegistryConfig registryConfig = new RegistryConfig();
//		registryConfig.setAddress("zookeeper://127.0.0.1:2181");
//		registryConfig.setClient("curator");
//		return registryConfig;
//	}

}
