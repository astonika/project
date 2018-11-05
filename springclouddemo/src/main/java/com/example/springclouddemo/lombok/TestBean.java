package com.example.springclouddemo.lombok;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class TestBean {
	private String name;
	private int age;
}
