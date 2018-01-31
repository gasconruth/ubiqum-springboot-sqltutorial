package com.ubiqum.sqltutorial;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringAnnotationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAnnotationsApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(BookRepository bookRepository, BookshelfRepository bookshelfRepository)
	{
		return (args) -> {
			Bookshelf topShelf = new Bookshelf("Top", 10);
			Bookshelf bottomShelf = new Bookshelf("Bottom", 8);
			bookshelfRepository.save(topShelf);
			bookshelfRepository.save(bottomShelf);

			Book book1 = new Book("How to decide book titles", "John doe", topShelf);
			Book book2 = new Book("Writing books for dummies", "Dumb dumbings", topShelf);
			Book book3 = new Book("The same", "Any programmer", topShelf);
			Book book4 = new Book("Living under the influence of Java", "Mr Java", bottomShelf);
			Book book5 = new Book("Java and other mythological beasts", "H. P. Lovecraft", bottomShelf);
			Book book6 = new Book("Java and the infinite love of programming", "Mr Java", bottomShelf);
			Book book7 = new Book("Why Java rules", "Mr Java", bottomShelf);
			Book book8 = new Book("Writing book titles for dummies", "Dumb dumbings", bottomShelf);
			Book book9 = new Book("Who am I?", "John Doe", bottomShelf);

			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);
			bookRepository.save(book4);
			bookRepository.save(book5);
			bookRepository.save(book6);
			bookRepository.save(book7);
			bookRepository.save(book8);
			bookRepository.save(book9);


			List<Book> books;
			List<Bookshelf> bookshelves;

			System.out.println("\n\nGet information about all Book\n");
			books = bookRepository.findAll();
			for(Book book : books)
			{
				System.out.println(book.getTitle());
			}

			System.out.println("\n\nGet information about all Book by a specific author\n");
			books = bookRepository.findByAuthor("Mr Java");
			for(Book book : books)
			{
				System.out.println(book.getTitle());
			}

			System.out.println("\n\nGet information about all Book with a title containing a certain text\n");
			books = bookRepository.findByTitleContaining("Java");
			for(Book book : books)
			{
				System.out.println(book.getTitle());
			}

			System.out.println("\n\nGet information about all Bookshelf with a capacity greater than a minimum\n");
			bookshelves = bookshelfRepository.findByCapacityGreaterThan(9);
			for(Bookshelf bookshelf : bookshelves)
			{
				System.out.println(bookshelf.getLocation());
			}

			System.out.println("\n\nGet information about all Book that are placed on a certain Bookshelf (selected by its location property)\n");
			books = bookRepository.findByBookshelfLocation("Top");
			for(Book book : books)
			{
				System.out.println(book.getTitle());
			}

		};
	}
}
