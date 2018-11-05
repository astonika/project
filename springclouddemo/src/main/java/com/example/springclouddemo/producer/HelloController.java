package com.example.springclouddemo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello() {
		ServiceInstance instance = client.getLocalServiceInstance();
		return "hello " + instance.getHost() + "," + instance.getPort() + "," + instance.getServiceId();
	}

	@RequestMapping(value="/hello2",method=RequestMethod.GET)
    public String sayHello2(){
        return "hello";
    }
}
