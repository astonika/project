package com.company.project.model;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class AnswerComment implements Serializable {
    private Integer id;

    private String content;

    private Integer userId;

    private Integer answerId;

    private static final long serialVersionUID = 1L;
}