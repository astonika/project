package com.aidian.middleware.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aidian.middleware.service.DemoService;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;

@Service
public class DemoServiceImpl implements DemoService {

	@Override
	public String sayHello(String name) {
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name
				+ ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
		return "Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress();
	}

}
