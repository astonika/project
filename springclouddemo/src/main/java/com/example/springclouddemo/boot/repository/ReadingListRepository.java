package com.example.springclouddemo.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springclouddemo.boot.entity.Book;

public interface ReadingListRepository extends JpaRepository<Book, Long> {
	List<Book> findByReader(String reader);
}
