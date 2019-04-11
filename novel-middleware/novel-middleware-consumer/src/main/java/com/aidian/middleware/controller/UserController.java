package com.aidian.middleware.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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

	/**
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/signin", method = GET)
	@ResponseBody
	public int signin(String username, String password) {
		int i = userService.signin(username, password);
		return i;
	}

	/**
	 * @param phoneOrEmail
	 * @param password
	 */
	@RequestMapping("/login")
	public void login(String phoneOrEmail, String password) {
		userService.login(phoneOrEmail, password);
	}

}
