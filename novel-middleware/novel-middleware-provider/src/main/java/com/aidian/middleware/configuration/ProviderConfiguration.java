/**
 * 
 */
package com.aidian.middleware.configuration;

/**
 * @author cdz
 *
 */
//@Configuration
//@EnableDubbo(scanBasePackages = "com.aidian.middleware.service.impl")
//@PropertySource("classpath:/spring/dubbo-provider.properties")
public class ProviderConfiguration {
	
//	com.alibaba.dubbo.config.ServiceConfig
//	com.alibaba.dubbo.config.ReferenceConfig
//	com.alibaba.dubbo.config.ProtocolConfig
//	com.alibaba.dubbo.config.RegistryConfig
//	com.alibaba.dubbo.config.MonitorConfig
//	com.alibaba.dubbo.config.ApplicationConfig
//	com.alibaba.dubbo.config.ModuleConfig
//	com.alibaba.dubbo.config.ProviderConfig
//	com.alibaba.dubbo.config.ConsumerConfig
//	com.alibaba.dubbo.config.MethodConfig
//	com.alibaba.dubbo.config.ArgumentConfig
	
	

//	@Bean // #1
//	public ProviderConfig providerConfig() {
//		ProviderConfig providerConfig = new ProviderConfig();
//		providerConfig.setTimeout(1000);
//		return providerConfig;
//	}

//	@Bean
//	public ApplicationConfig applicationConfig() {
//		ApplicationConfig applicationConfig = new ApplicationConfig();
//		applicationConfig.setName("novel-middleware-provider");
//		return applicationConfig;
//	}

//	@Bean
//	public RegistryConfig registryConfig() {
//		RegistryConfig registryConfig = new RegistryConfig();
//		registryConfig.setAddress("zookeeper://127.0.0.1:2181");
////        registryConfig.setAddress("10.20.130.230:9090");
////        registryConfig.setUsername("aaa");
////        registryConfig.setPassword("bbb");
//		registryConfig.setClient("curator");
//		return registryConfig;
//	}

//	@Bean // #3
//    public RegistryConfig registryConfig() {
//        RegistryConfig registryConfig = new RegistryConfig();
//        registryConfig.setProtocol("zookeeper");
//        registryConfig.setAddress("localhost");
//        registryConfig.setPort(2181);
//        return registryConfig;
//    }

//	@Bean
//	public ProtocolConfig protocolConfig() {
//		ProtocolConfig protocolConfig = new ProtocolConfig("dubbo", 20880);
////		ProtocolConfig protocolConfig = new ProtocolConfig("hessian", 8080);
//		return protocolConfig;
//	}
}
