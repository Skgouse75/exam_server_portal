package com.api.book.bootrestbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.Dao.BookRepository;
import com.api.book.bootrestbook.entity.Book;

@Component
public class BookService {
	
	//this is fake service layer because we not collecting data from DB
	//we create list of books 
	/* when we are using Db source then neglect
	 * private static List<Book>list=new ArrayList<>();
	  static {
		   list.add(new Book(12,"gh","learn java"));
		   list.add(new Book(13,"hf","learn springboot"));
		   list.add(new Book(14,"fp","learn hibernate"));
	   }*/
	
	
	   //get all books
	/*   public List<Book>getAllBooks()
	   {
			return list;
		   
	   }
// get single book by id
// if id is match with in this list id that list will show 
// predicate means we pass lambda function  
	   // if use optional object use getmethod
	   public Book getBookById(int id)
	   {
		   Book book=null;
		   try {
	    book= list.stream().filter(e->e.getId()==id).findFirst().get();	   
		   }
		   catch(Exception e)
		   { 
			  e.printStackTrace();
		   }
		   return book;
	   }
	   
	   //adding book
	   public Book addBook(Book b)
	   {
		   list.add(b);
		   
		   return b;
	   }
	   
	   //delete book
	   public void deleteBook(int bid)
	   {
		  list= list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
			   if(book.getId()!=bid)
			   {
				   return true;
			   }
			   else {
				   return false;
			   }
		   }).collect(Collectors.toList());
	   }
	   
	   public void UpdateBook(Book book, int bookId)
	   {
		   list.stream().map(b->{
			   if(b.getId()==bookId) 
			   {
				   b.setTitle(book.getTitle());
				   b.setAuthor(book.getAuthor());
				   
			   }
			   return b;
		   }).collect(Collectors.toList());
	   }*/
	   
	   
	   @Autowired
	   private BookRepository bookRepository;
	   
	   public List<Book>getAllBooks()
	   {
		  // canot convert Iterable book to ListBook
		  List<Book>list=(List<Book>) this.bookRepository.findAll();
			return list;   
	   }
	   
	   public Book getBookById(int id)
	   {
		   Book book=null;
		   try {
	    //book= list.stream().filter(e->e.getId()==id).findFirst().get();
			 book= this.bookRepository.findById(id);
		   }
		   catch(Exception e)
		   { 
			  e.printStackTrace();
		   }
		   return book;
	   }
	   
	   public Book addBook(Book b)
	   {
		 Book result=  bookRepository.save(b);
		   
		   return 	result;
	   }
	   
	   public void deleteBook(int bid)
	   {
		 //list= list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
			bookRepository.deleteById(bid);  
	   }
	   
	   public void UpdateBook(Book book, int bookId)
	   {
		   book.setId(bookId);
		   bookRepository.save(book);
	   }
	   
	   
}
