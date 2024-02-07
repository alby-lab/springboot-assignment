package com.agridence.microservice.Assignment.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agridence.microservice.Assignment.dto.PersonalNoteDto;
import com.agridence.microservice.Assignment.entity.PersonalNote;
import com.agridence.microservice.Assignment.entity.UserInfo;
import com.agridence.microservice.Assignment.repository.PersonalNoteRepository;
import com.agridence.microservice.Assignment.repository.UserRepository;

@Service
public class PersonalNoteServiceImpl implements PersonalNoteService{
	@Autowired
	UserRepository repository;
	@Autowired
	PersonalNoteRepository personalNoteRepository;

	@Override
	public List<PersonalNote> save(List<PersonalNoteDto> notes) {
		 PersonalNote note=new PersonalNote();
		 List<PersonalNote> personalNotes=new ArrayList<PersonalNote>();
		for (PersonalNoteDto personalNoteDto : notes) {
			 note.setNoteTitile(personalNoteDto.getNoteTitile());
			 note.setNoteDescriptions(personalNoteDto.getNoteDescriptions());
			 UserInfo user=repository.findByUsername(personalNoteDto.getUsername());
			 note.setUser(user);
			 personalNotes.add(note);
		 }
		
		return personalNoteRepository.saveAll(personalNotes);
	}

	@Override
	public List<PersonalNoteDto> fetchAllNotesByUsername(String username) {
		    List<PersonalNoteDto> personaldtoNotes=new ArrayList<PersonalNoteDto>();
		    UserInfo user=repository.findByUsername(username);
		    List<PersonalNote> personalNotes=personalNoteRepository.findAllByUserId(user.getUserId());
		   PersonalNoteDto notedto =new PersonalNoteDto();
			for (PersonalNote personalNo : personalNotes) {
				
				notedto.setNoteTitile(personalNo.getNoteTitile());
				notedto.setNoteDescriptions(personalNo.getNoteDescriptions());
				 UserInfo userinfo=repository.findByUsername(personalNo.getUser().getUsername());
				 notedto.setUsername(userinfo.getUsername());
				 personaldtoNotes.add(notedto);
			 }
		return personaldtoNotes;
	}


	@Override
	public PersonalNote updateNote(PersonalNoteDto notedto, int noteId) {
		Optional<PersonalNote> noteOption=personalNoteRepository.findById(noteId);
		 PersonalNote existingNote=new PersonalNote();
		 existingNote.setNoteId(noteOption.get().getNoteId());
		 existingNote.setNoteTitile(notedto.getNoteTitile());
		 existingNote.setNoteDescriptions(notedto.getNoteDescriptions());
		 
		return personalNoteRepository.save(existingNote);
	}

	
	@Override
	public void deleteAllById(int noteId) {
	personalNoteRepository.deleteAllById(noteId);
	}


	

}
