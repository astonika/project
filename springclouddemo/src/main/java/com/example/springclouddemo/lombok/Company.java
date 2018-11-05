/**
 * 
 */
package com.example.springclouddemo.lombok;

import java.util.List;

import lombok.Data;

@Data(staticConstructor = "of")
public class Company {
	private final Person founder;
	private String name;
	private List<Person> employees;
}
