package com.example.springclouddemo.lombok;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Astonika
 * @source https://blog.csdn.net/blueheart20/article/details/52909775
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestEntityBean {

	TestBean bean = new TestBean();

	// @Autowired
	// private MyCase mycase;

	// @Test
	public void test() {
		bean.setAge(123);
		bean.setName("zhangsan");

		log.info(bean.toString());
	}
}
