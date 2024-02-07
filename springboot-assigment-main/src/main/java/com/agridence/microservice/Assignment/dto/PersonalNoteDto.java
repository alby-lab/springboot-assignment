package com.agridence.microservice.Assignment.dto;

import jakarta.persistence.Column;

public class PersonalNoteDto {
	private String noteTitile;
	private String noteDescriptions;
	private String username;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
