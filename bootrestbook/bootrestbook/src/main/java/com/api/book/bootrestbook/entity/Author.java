package com.api.book.bootrestbook.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name="authors")
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int authorid;
	private String firstname;
	private String lastname;
	private String language;
	
	@OneToOne(mappedBy="author")
	@JsonBackReference 
	private Book book;
	
	
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "Author [authorid=" + authorid + ", firstname=" + firstname + ", lastname=" + lastname + ", language="
				+ language + "]";
	}
	public Author(int authorid, String firstname, String lastname, String language) {
		super();
		this.authorid = authorid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.language = language;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
}
