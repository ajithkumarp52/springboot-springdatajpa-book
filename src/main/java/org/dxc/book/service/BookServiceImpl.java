package org.dxc.book.service;

import java.util.List;
import java.util.Optional;

import org.dxc.book.model.Book;
import org.dxc.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> findAll() {
		
		return bookRepository.findAll();
	}
	@Override
	public Object save(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	@Override
	public Optional<Book> getBook(int bookId) {
		
		return bookRepository.findById(bookId);
	}
	@Override
	public void deletebyid(int bookId) {
		bookRepository.deleteById(bookId);
		
		
	}
	@Override
	public void updateBook(Book book, int bookId) {
		Book updateBook=bookRepository.getOne(bookId);
		updateBook.setAuthorName(book.getAuthorName());
		updateBook.setBookName(book.getBookName());
		updateBook.setPublisher(book.getPublisher());
		updateBook.setCategory(book.getCategory());
		updateBook.setIsbn(book.getIsbn());
		updateBook.setPrice(book.getPrice());
		bookRepository.save(book);
		
	}
	@Override
	public List<Book> findByAuthorName(String authorName) {
		
		return bookRepository.findByAuthorName(authorName);
	}
	@Override
	public List<Book> findByPublisher(String publisher) {
		
		return bookRepository.findByPublisher(publisher);
	}
	@Override
	public List<Book> findByCategory(String category) {
		
		return bookRepository.findByCategory(category);
	}
	

	

}
