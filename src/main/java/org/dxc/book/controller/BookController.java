package org.dxc.book.controller;

import java.util.List;
import java.util.Optional;

import org.dxc.book.model.Book;
import org.dxc.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookController {
	@Autowired
	private BookService bookService;
	@RequestMapping("/findall")
	public List<Book> findAllBooks(){
		return bookService.findAll();
		}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public HttpStatus saveBook(@RequestBody Book book) {
		
	boolean status=bookService.save(book)!=null;
	return status ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;	
	}
	@RequestMapping("/byid")
	public Optional<Book> getBook(@RequestParam("bookId")int bookId){
		Optional<Book> result=bookService.getBook(bookId);
		return result;
	}
	@RequestMapping("/findByAuthor")
	public List<Book> fetchDataByAuthor(@RequestParam("authorName")String authorName){
	return bookService.findByAuthorName(authorName);
	}
	@RequestMapping("/findByPublisher")
	public List<Book> fetchDataByPublisher(@RequestParam("publisher")String publisher){
	return bookService.findByPublisher(publisher);
	}
	@RequestMapping("/findByCategory")
	public List<Book> fetchDataByCategory(@RequestParam("category")String category){
	return bookService.findByCategory(category);
	}
	@DeleteMapping("/delete")
	public void deleteBook(@RequestParam("bookId")int bookId) {
		bookService.deletebyid(bookId);
	}
	@PutMapping("/updatebook")
	public void updateBook(@RequestBody Book book,@RequestParam("bookId")int bookId) {
		bookService.updateBook(book,bookId);
	}

}
