package com.company.project.service.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.alibaba.dubbo.config.annotation.Service;
import com.company.project.dao.UserMapper;
import com.company.project.model.User;
import com.company.project.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
//	@Autowired
//	private JmsTemplate jmsTemplate;

	public static final String INSERT = "insert";
	public static final String INSERT_SELECTIVE = "insertSelective";
	public static final String UPDATE_BY_EXAMPLE_SELECTIVE = "updateByExampleSelective";
	public static final String UPDATE_BY_EXAMPLE = "updateByExample";
	public static final String UPDATE_BY_PRIMARY_KEY_SELECTIVE = "updateByPrimaryKeySelective";
	public static final String UPDATE_BY_PRIMARY_KEY = "updateByPrimaryKey";
	public static final String DELETE_BY_EXAMPLE = "deleteByExample";
	public static final String DELETE_BY_PRIMARY_KEY = "deleteByPrimaryKey";

	@Override
	public int signin(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		int insertNum = userMapper.insertSelective(user);
		StringBuilder sb = new StringBuilder(INSERT_SELECTIVE);
//		jmsTemplate.send(sb.append("#").append(user.getClass().getCanonicalName()).toString(), new MessageCreator() {
//			@Override
//			public Message createMessage(Session session) throws JMSException {
//				return session.createObjectMessage(user);
//			}
//		});
		return insertNum;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(UserServiceImpl[][][][].class.getTypeName());
		System.out.println(UserServiceImpl[][][][].class.getCanonicalName());
		System.out.println(UserServiceImpl[][][][].class.getName());
		System.out.println(UserServiceImpl[][][][].class.getSimpleName());
//		UserServiceImpl[][][][] ss = Class.forName("").newInstance();
	}

	@Override
	public void login(String username, String password) {

	}

	@Override
	public void logoff(String username) {
	}

}
