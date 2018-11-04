package com.company.project.model;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String email;

    private static final long serialVersionUID = 1L;
}