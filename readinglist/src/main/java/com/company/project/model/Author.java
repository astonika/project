package com.company.project.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Author extends AuthorKey implements Serializable {
    private String email;

    private String authorName;

    private Date startDate;

    private static final long serialVersionUID = 1L;
}