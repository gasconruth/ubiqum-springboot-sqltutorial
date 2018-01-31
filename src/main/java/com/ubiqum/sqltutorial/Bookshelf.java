package com.ubiqum.sqltutorial;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Bookshelf {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String location;
	private Integer capacity;

	@OneToMany(mappedBy = "bookshelf", fetch = FetchType.EAGER)
	private Set<Book> books = new HashSet<>();

	public Bookshelf(){}

	public Bookshelf(String location, Integer capacity) {
		this.location = location;
		this.capacity = capacity;
	}

	public long getId() {
		return id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public void addBook(Book book) {
		books.add(book);
	}
}
