package com.example.springclouddemo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ConsumerController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/hello3", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "helloError")
	public String hello() {
		return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
	}

	public String helloError() {
		return "服务器出现故障";
	}
}