package com.ubiqum.sqltutorial;

import javax.persistence.*;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String title;
	private String author;

	@JoinColumn(name = "bookshelf_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Bookshelf bookshelf;

	public Book(){}

	public Book(String title, String author, Bookshelf bookshelf) {
		this.title = title;
		this.author = author;
		this.bookshelf = bookshelf;
		bookshelf.addBook(this);
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
