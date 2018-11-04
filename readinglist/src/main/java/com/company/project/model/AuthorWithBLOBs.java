package com.company.project.model;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AuthorWithBLOBs extends Author implements Serializable {
    private byte[] password;

    private byte[] bio;

    private static final long serialVersionUID = 1L;
}