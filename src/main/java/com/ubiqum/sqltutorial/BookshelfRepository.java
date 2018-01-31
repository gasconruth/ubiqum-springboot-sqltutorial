package com.ubiqum.sqltutorial;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookshelfRepository extends JpaRepository<Bookshelf, Long> {
	List<Bookshelf> findByCapacityGreaterThan (Integer minimum);
}
