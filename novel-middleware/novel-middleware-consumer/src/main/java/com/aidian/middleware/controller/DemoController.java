/**
 * 
 */
package com.aidian.middleware.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aidian.middleware.service.DemoService;
import com.alibaba.dubbo.config.annotation.Reference;

/**
 * @author cdz
 *
 */
//@Controller
//@RestController
public class DemoController {

	@Reference
	private DemoService demoService; // get remote service proxy

	/**
	 * 
	 */
	public void sayHello() {
		while (true) {
			try {
				Thread.sleep(1000);
				String hello = demoService.sayHello("world"); // call remote method
				System.out.println(hello); // get result
			} catch (Throwable throwable) {
				throwable.printStackTrace();
			}
		}
	}

	@RequestMapping("/sayHello")
	public String sayHello(@RequestParam String name) {
		return demoService.sayHello(name);
	}
}
