package com.api.book.bootrestbook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entity.Book;
import com.api.book.bootrestbook.service.BookService;

@RestController
public class BookController {

	//@RequestMapping(value="/book", method=RequestMethod.GET)
	//@ResponseBody
	
	/*	@GetMapping("/book")
	public String getbooks() {
		
		//this return method is view or jsp page like in spring mvc. as is ot goes as string in html 
		//page then we ae required a annotation that is @ResponseBody
	//======================= or=================================
	// in place of @Controller we use RESTController then we no need to write the @ResponseBody
	//if we write GETMapping it combines the @RequestMapping and RequestMethod so no need to write
	// to send json  data we create book object before object create we need to create class Entity
		
	Book book=new Book();
	 book.setId(45);
	 book.setAuthor("gh");
	 book.setTitle("learn java");
	return "this is testing book first";
	}*/
	@Autowired
	private BookService bookService;
	
	/*@GetMapping("/books")
	public List<Book>getBooks()
	{
		return this.bookService.getAllBooks();
		
	}*/
	
	
	
	// for set HTTP status
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks()
	{
		List<Book>list= this.bookService.getAllBooks();
		if(list.size()<=0) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return    ResponseEntity.status(HttpStatus.CREATED).body(list)
				;
		
	}
	
	//getting http status on single book
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id")int id)
	{
		Book book=bookService.getBookById(id);
		if(book==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
		
	  }
	
	
	// post http status
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
	 Book b=null;
	 try {
		 b=	this.bookService.addBook(book);
		 System.out.println(book);
		 return ResponseEntity.of(Optional.of(b));
	 }
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
	}
	
	//delete Http status 
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void>deletebook(@PathVariable ("bookId") int bookId)
	{ 
		try {
			 this.bookService.deleteBook(bookId );
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	//update HTTPStatus
	
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("bookId")int bookId) {
		
		try{
			this.bookService.UpdateBook(book, bookId);
			return ResponseEntity.ok().body(book);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
	}	
	
	
	
	
	
	
	
	
	
	
	
	
/*	//for getting single book handler
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id")int id) {
		return this.bookService.getBookById(id);
		
	}*/
	
	/*//new book handler
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
	Book b=	this.bookService.addBook(book);
	System.out.println(book);
		return b;
		
	}*/
	
	//delete handler
	/*@DeleteMapping("/books/{bookId}")
	public void deletebook(@PathVariable ("bookId") int bookId){
		 this.bookService.deleteBook(bookId );

	}*/
	
	//update book handler
	
	/*@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book,@PathVariable("bookId")int bookId) {
		this.bookService.UpdateBook(book, bookId);
		return null;
		
	}*/
	
	

}