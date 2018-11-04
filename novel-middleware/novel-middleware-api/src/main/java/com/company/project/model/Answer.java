package com.company.project.model;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Answer implements Serializable {
    private Integer id;

    private String content;

    private Integer userId;

    private Integer upvote;

    private Integer downvote;

    private Integer questionId;

    private static final long serialVersionUID = 1L;
}