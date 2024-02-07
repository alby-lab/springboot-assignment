package com.agridence.microservice.Assignment.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="personalnote")
public class PersonalNote implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int noteId;
	@Column(name="noteTitile")
	private String noteTitile;
	@Column(name="noteDescriptions")
	private String noteDescriptions;
	
	@ManyToOne
    @JoinColumn(name="userId", nullable=false)
    private UserInfo user;
	
	public int getNoteId() {
		return noteId;
	}
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public String getNoteTitile() {
		return noteTitile;
	}
	public void setNoteTitile(String noteTitile) {
		this.noteTitile = noteTitile;
	}
	public String getNoteDescriptions() {
		return noteDescriptions;
	}
	public void setNoteDescriptions(String noteDescriptions) {
		this.noteDescriptions = noteDescriptions;
	}
	
	

}
