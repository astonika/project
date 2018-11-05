/**
 * 
 */
package com.example.springclouddemo.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springclouddemo.boot.entity.Reader;

/**
 * @author Astonika
 *
 */
public interface ReaderRepository extends JpaRepository<Reader, String> {

	/**
	 * @param username
	 * @return
	 */
	@Override
	Reader findOne(String username);
}
