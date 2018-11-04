/**
 * 
 */
package com.company.project.service.impl;

import java.util.ArrayList;

import com.company.project.model.AuthorExample;

import lombok.Data;

/**
 * @author Administrator
 *
 */
public class Foobar {

	public static void main(String[] args) {
		AuthorExample example = new AuthorExample();
		example.setDistinct(true);
		example.createCriteria().andAuthorNameEqualTo("sss");
		example.or().andAuthorNameNotIn(new ArrayList<>()).andFirstNameSoundsLike("frod").andAuthorNameEqualTo("ssss");
		System.out.println(example);

		System.out.println(Data.class);
	}

}
