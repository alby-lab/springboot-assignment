package com.agridence.microservice.Assignment.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agridence.microservice.Assignment.dto.PersonalNoteDto;
import com.agridence.microservice.Assignment.entity.PersonalNote;
import com.agridence.microservice.Assignment.services.PersonalNoteService;

@RestController
@RequestMapping("/api/notes")
public class PersonalNoteController {
	
	@Autowired
	PersonalNoteService personalNoteService;
	
	@PostMapping("/createNotes")
	public ResponseEntity<List<PersonalNoteDto>> saveUser(@RequestBody List<PersonalNoteDto>notes) throws Exception {
		PersonalNoteDto dto=new PersonalNoteDto();
		List<PersonalNoteDto>personalNotes=new ArrayList<PersonalNoteDto>();
		List<PersonalNote>savedNotes=personalNoteService.save(notes);
		for (PersonalNote personalNote : savedNotes) {
			dto.setNoteDescriptions(personalNote.getNoteDescriptions());
			dto.setNoteTitile(personalNote.getNoteTitile());
			dto.setUsername(personalNote.getUser().getUsername());
			personalNotes.add(dto);
		}
		
		return new ResponseEntity<>(personalNotes,HttpStatus.CREATED);
	}
	
	@GetMapping("/viewnotes/{username}")
	public ResponseEntity<List<PersonalNoteDto>> viewAllNotes(@PathVariable("username") String username) throws Exception {
		List<PersonalNoteDto>notes=personalNoteService.fetchAllNotesByUsername(username);
		return new ResponseEntity<>(notes,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> upadteNotes(@RequestBody PersonalNoteDto notes,@PathVariable int noteId) throws Exception {
		
		   
		    PersonalNoteDto updatedResponse =new PersonalNoteDto();
		    PersonalNote updatedNote= personalNoteService.updateNote(notes,noteId);
		    updatedResponse.setNoteDescriptions(updatedNote.getNoteDescriptions());
		    updatedResponse.setNoteTitile(updatedNote.getNoteTitile());
		    updatedResponse.setUsername(updatedNote.getUser().getUsername());
	        return new ResponseEntity<>(updatedResponse, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteNotes(@PathVariable int noteId) throws Exception {
		personalNoteService.deleteAllById(noteId);
		return new ResponseEntity<>("Notes successfully deleted!", HttpStatus.OK);
	}
}
