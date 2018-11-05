/**
 * 
 */
package com.example.springclouddemo.lombok;

import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Astonika
 *
 */
public class Family {

	/**
	 * 
	 */
	@Getter
	@Setter
	@NonNull
	private List<Person> members;
}
