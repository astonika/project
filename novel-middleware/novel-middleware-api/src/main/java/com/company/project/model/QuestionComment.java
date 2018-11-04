package com.company.project.model;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class QuestionComment implements Serializable {
    private Integer id;

    private String content;

    private Integer userId;

    private Integer questionId;

    private static final long serialVersionUID = 1L;
}