package com.company.project.domain;

import java.io.Serializable;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table author
 */
public class Author implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column author.Id
     *
     * @mbg.generated Tue Oct 02 21:45:37 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table author
     *
     * @mbg.generated Tue Oct 02 21:45:37 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column author.Id
     *
     * @return the value of author.Id
     *
     * @mbg.generated Tue Oct 02 21:45:37 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column author.Id
     *
     * @param id the value for author.Id
     *
     * @mbg.generated Tue Oct 02 21:45:37 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }
}