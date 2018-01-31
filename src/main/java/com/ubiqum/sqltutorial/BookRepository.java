package com.ubiqum.sqltutorial;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByAuthor(String authorName);
	List<Book> findByBookshelfLocation (String location);
	List<Book> findByTitleContaining (String text);
}
