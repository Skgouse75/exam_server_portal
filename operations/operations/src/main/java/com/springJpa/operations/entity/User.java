package com.springJpa.operations.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String status;
	private String cit;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCit() {
		return cit;
	}
	public void setCit(String cit) {
		this.cit = cit;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", status=" + status + ", cit=" + cit + "]";
	}
	public User(int id, String name, String status, String cit) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.cit = cit;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
