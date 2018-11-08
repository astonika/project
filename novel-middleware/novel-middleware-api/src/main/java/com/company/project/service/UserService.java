package com.company.project.service;

public interface UserService {

	int signinByMobile(String mobile);

	int signin(String username, String password);

	void login(String mobileOrEmail, String password);

	void logoff(String username);

}