/**
 * 
 */
package com.example.springclouddemo.boot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.example.springclouddemo.boot.condition.JdbcTemplateCondition;
import com.example.springclouddemo.boot.service.MyService;

/**
 * @author Astonika
 *
 */
@Configuration
public class AutoConfiguration {

	@Bean
	@Conditional(JdbcTemplateCondition.class)
	public MyService myService() {
		return new MyService();
	}

}
