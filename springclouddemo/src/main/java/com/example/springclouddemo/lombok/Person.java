package com.example.springclouddemo.lombok;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AccessLevel;
import lombok.Cleanup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.Synchronized;

/**
 * @author Astonika
 * @source http://jnb.ociweb.com/jnb/jnbJan2010.html
 * @extra https://www.cnblogs.com/holten/p/5729226.html
 */
@Data
@EqualsAndHashCode(callSuper = true, exclude = { "address", "city", "state", "zip" })
public class Person extends SentientBeing {
	private final String firstName;
	private final String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private final Date dateofBirth;

	@Getter
	@Setter
	private boolean employed = true;
	@Setter(AccessLevel.PROTECTED)
	@NonNull
	private String name;

	enum Gender {
		Male, Female
	}

	@NonNull
	private Gender gender;

	private String ssn;

	/**
	 * 
	 */
	public void testCleanUp() {
		try {
			@Cleanup
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			baos.write(new byte[] { 'Y', 'e', 's' });
			System.out.println(baos.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private DateFormat format = new SimpleDateFormat("MM-dd-YYYY");

	@Synchronized
	public String synchronizedFormat(Date date) {
		return format.format(date);
	}

	@SneakyThrows
	public void testSneakyThrows() {
		throw new IllegalAccessException();
	}

}
