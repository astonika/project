package com.company.project.dao;

import com.company.project.model.Author;
import com.company.project.model.AuthorExample;
import com.company.project.model.AuthorKey;
import com.company.project.model.AuthorWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AuthorMapper {
    @SelectProvider(type=AuthorSqlProvider.class, method="countByExample")
    long countByExample(AuthorExample example);

    @DeleteProvider(type=AuthorSqlProvider.class, method="deleteByExample")
    int deleteByExample(AuthorExample example);

    @Delete({
        "delete from author",
        "where id = #{id,jdbcType=INTEGER}",
          "and username = #{username,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(AuthorKey key);

    @Insert({
        "insert into author (id, username, ",
        "email, author_name, ",
        "start_date, password, ",
        "bio)",
        "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{authorName,jdbcType=VARCHAR}, ",
        "#{startDate,jdbcType=DATE}, #{password,jdbcType=LONGVARBINARY}, ",
        "#{bio,jdbcType=LONGVARBINARY})"
    })
    int insert(AuthorWithBLOBs record);

    @InsertProvider(type=AuthorSqlProvider.class, method="insertSelective")
    int insertSelective(AuthorWithBLOBs record);

    @SelectProvider(type=AuthorSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="author_name", property="authorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_date", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="password", property="password", jdbcType=JdbcType.LONGVARBINARY),
        @Result(column="bio", property="bio", jdbcType=JdbcType.LONGVARBINARY)
    })
    List<AuthorWithBLOBs> selectByExampleWithBLOBs(AuthorExample example);

    @SelectProvider(type=AuthorSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="author_name", property="authorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_date", property="startDate", jdbcType=JdbcType.DATE)
    })
    List<Author> selectByExample(AuthorExample example);

    @Select({
        "select",
        "id, username, email, author_name, start_date, password, bio",
        "from author",
        "where id = #{id,jdbcType=INTEGER}",
          "and username = #{username,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="author_name", property="authorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_date", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="password", property="password", jdbcType=JdbcType.LONGVARBINARY),
        @Result(column="bio", property="bio", jdbcType=JdbcType.LONGVARBINARY)
    })
    AuthorWithBLOBs selectByPrimaryKey(AuthorKey key);

    @UpdateProvider(type=AuthorSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AuthorWithBLOBs record, @Param("example") AuthorExample example);

    @UpdateProvider(type=AuthorSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") AuthorWithBLOBs record, @Param("example") AuthorExample example);

    @UpdateProvider(type=AuthorSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Author record, @Param("example") AuthorExample example);

    @UpdateProvider(type=AuthorSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AuthorWithBLOBs record);

    @Update({
        "update author",
        "set email = #{email,jdbcType=VARCHAR},",
          "author_name = #{authorName,jdbcType=VARCHAR},",
          "start_date = #{startDate,jdbcType=DATE},",
          "password = #{password,jdbcType=LONGVARBINARY},",
          "bio = #{bio,jdbcType=LONGVARBINARY}",
        "where id = #{id,jdbcType=INTEGER}",
          "and username = #{username,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKeyWithBLOBs(AuthorWithBLOBs record);

    @Update({
        "update author",
        "set email = #{email,jdbcType=VARCHAR},",
          "author_name = #{authorName,jdbcType=VARCHAR},",
          "start_date = #{startDate,jdbcType=DATE}",
        "where id = #{id,jdbcType=INTEGER}",
          "and username = #{username,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Author record);
}