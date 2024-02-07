package com.agridence.microservice.Assignment.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="userinfo")
public class UserInfo implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="userId")
	private int userId;
	@Column(name="username")
	private String username;
	@Column(name="username")
	private String password;
	@Column(name="fullname")
	private String fullname;
	
	@OneToMany(mappedBy="userinfo")
	 List<PersonalNote> personalNotes;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public List<PersonalNote> getPersonalNotes() {
		return personalNotes;
	}
	public void setPersonalNotes(List<PersonalNote> personalNotes) {
		this.personalNotes = personalNotes;
	}
	
	
	

}
