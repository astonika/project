package com.company.project.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class AuthorKey implements Serializable {
    private Integer id;

    private String username;

    private static final long serialVersionUID = 1L;
}