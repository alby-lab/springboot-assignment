package com.agridence.microservice.Assignment.services;

import java.util.List;

import com.agridence.microservice.Assignment.dto.PersonalNoteDto;
import com.agridence.microservice.Assignment.entity.PersonalNote;

public interface PersonalNoteService {

	
	List<PersonalNote> save(List<PersonalNoteDto> notes);
	List<PersonalNoteDto> fetchAllNotesByUsername(String username);
	PersonalNote updateNote(PersonalNoteDto notes, int noteId);
	void deleteAllById(int noteId);
	
	

	

	

	
}
