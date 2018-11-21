package com.yonyou.paas.middleware.service.impl;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceHystric implements HelloService {
	@Override
	public String hiService(String name) {
		return "sorry " + name;
	}
}