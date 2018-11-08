package com.company.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.company.project.dao.UserMapper;
import com.company.project.model.User;
import com.company.project.service.UserService;
import com.company.project.sms.CodeStatus;
import com.company.project.sms.SmsTemplate;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
//	@Autowired
//	private JmsTemplate jmsTemplate;

	@Autowired
	private SmsTemplate smsTemplate;

	public static final String INSERT = "insert";
	public static final String INSERT_SELECTIVE = "insertSelective";
	public static final String UPDATE_BY_EXAMPLE_SELECTIVE = "updateByExampleSelective";
	public static final String UPDATE_BY_EXAMPLE = "updateByExample";
	public static final String UPDATE_BY_PRIMARY_KEY_SELECTIVE = "updateByPrimaryKeySelective";
	public static final String UPDATE_BY_PRIMARY_KEY = "updateByPrimaryKey";
	public static final String DELETE_BY_EXAMPLE = "deleteByExample";
	public static final String DELETE_BY_PRIMARY_KEY = "deleteByPrimaryKey";

	@Override
	public int signinByMobile(String mobile) {
		String nonce = "123456";
		String templateId = "3057527";
		String codeLen = "6";
		try {

			if (CodeStatus.OK.getCode().equals(smsTemplate.sendCode(nonce, templateId, mobile, codeLen))) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int signin(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		int insertNum = userMapper.insertSelective(user);
		System.err.println(user.getId());
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
	public void login(String mobileOrEmail, String password) {
		if (isMobile(mobileOrEmail)) {

		}

	}

	private boolean isMobile(String phoneOrEmail) {
		return true;
	}

	private boolean isEmail(String phoneOrEmail) {
		return true;
	}

	@Override
	public void logoff(String username) {
	}

}
