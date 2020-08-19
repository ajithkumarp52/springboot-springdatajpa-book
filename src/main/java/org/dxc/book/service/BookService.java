package org.dxc.book.service;

import java.util.List;
import java.util.Optional;

import org.dxc.book.model.Book;

public interface BookService {

	List<Book> findAll();

	Object save(Book book);

	Optional<Book> getBook(int bookId);

	void deletebyid(int bookId);

	void updateBook(Book book, int bookId);

	List<Book> findByAuthorName(String authorName);

	List<Book> findByPublisher(String publisher);

	List<Book> findByCategory(String category);
	

}
