package com.company.project.service;

public interface UserService {

	int signin(String username, String password);
	
	void login(String username, String password);

	void logoff(String username);

}