package com.aidian.middleware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.service.UserService;

@RestController
public class UserController {

	public UserController() {
		System.out.println("===========================");
		System.out.println("===========================");
		System.out.println("===========================");
		System.out.println("===========================");
		System.out.println("===========================");
		System.out.println("===========================");
	}

	@Autowired
	private UserService userService;

	@RequestMapping("/signin")
	@ResponseBody
	public int signin(String username, String password) {
		int i = userService.signin(username, password);
		return i;
	}

	@RequestMapping("/login")
	public void login(String username, String password) {
		userService.login(username, password);
	}

}
