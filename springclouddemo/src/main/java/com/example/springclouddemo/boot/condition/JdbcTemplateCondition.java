/**
 * 
 */
package com.example.springclouddemo.boot.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Astonika
 *
 */
public class JdbcTemplateCondition implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		try {
			context.getClassLoader().loadClass("org.springframework.jdbc.core.JdbcTemplate");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}