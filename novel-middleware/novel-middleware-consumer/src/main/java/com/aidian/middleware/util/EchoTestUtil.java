/**
 * 
 */
package com.aidian.middleware.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.aidian.middleware.service.DemoService;
import com.alibaba.dubbo.rpc.service.EchoService;

/**
 * @author cdz
 *
 */
public class EchoTestUtil {

	@Autowired
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		// 远程服务引用
		DemoService demoService = (DemoService) applicationContext.getBean("demoService");

		EchoService echoService = (EchoService) demoService; // 强制转型为EchoService

		// 回声测试可用性
		String status = (String) echoService.$echo("OK");

		assert (status.equals("OK"));
	}

}
