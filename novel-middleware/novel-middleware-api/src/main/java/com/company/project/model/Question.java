package com.company.project.model;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Question implements Serializable {
    private Integer id;

    private String title;

    private String content;

    private static final long serialVersionUID = 1L;
}