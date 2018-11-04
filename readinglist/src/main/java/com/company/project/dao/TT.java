/**
 * 
 */
package com.company.project.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.type.JdbcType;

/**
 * @author Administrator
 *
 */
public class TT {
	public static final Result[] rr = new Result[] {
		        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),@Result(column="username",property="username",jdbcType=JdbcType.VARCHAR,id=true),@Result(column="email",property="email",jdbcType=JdbcType.VARCHAR),@Result(column="author_name",property="authorName",jdbcType=JdbcType.VARCHAR),@Result(column="start_date",property="startDate",jdbcType=JdbcType.DATE),@Result(column="password",property="password",jdbcType=JdbcType.LONGVARBINARY),@Result(column="bio",property="bio",jdbcType=JdbcType.LONGVARBINARY)
};

}
