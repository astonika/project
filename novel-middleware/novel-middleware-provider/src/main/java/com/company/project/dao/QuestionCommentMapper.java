package com.company.project.dao;

import com.company.project.model.QuestionComment;
import com.company.project.model.QuestionCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionCommentMapper {
    long countByExample(QuestionCommentExample example);

    int deleteByExample(QuestionCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QuestionComment record);

    int insertSelective(QuestionComment record);

    List<QuestionComment> selectByExample(QuestionCommentExample example);

    QuestionComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QuestionComment record, @Param("example") QuestionCommentExample example);

    int updateByExample(@Param("record") QuestionComment record, @Param("example") QuestionCommentExample example);

    int updateByPrimaryKeySelective(QuestionComment record);

    int updateByPrimaryKey(QuestionComment record);
}