package com.hello.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hello.model.Note;
import com.hello.repository.NoteRepository;
import com.hello.service.INotesService;

@RestController
@RequestMapping("/api")
public class NoteController {

	@Autowired
	NoteRepository noteRepository;
	
	@Autowired
	INotesService noteService;
	
	
	// Get All Notes
	@GetMapping("/getNotes")
	//@RequestMapping(value="/notes", method=RequestMethod.Post) above is its short form
	public List<Note>getAllNotes(){
		List<Note> allNotes = noteService.getAllNotes();
	   return allNotes;
	}
	
	// Create a new Note
	@PostMapping("/createNote")
	public Note createNote(@Valid @RequestBody Note note) {
		Note addNote = noteService.addNote(note);
		return addNote;
	}
	
	//Get single note
	@GetMapping("/getById/{id}")
	public ResponseEntity<Note> getNoteById(@PathVariable(value="id") Long noteId) {
		
		Note note = noteService.getNoteById(noteId);
		if(note==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(note);
	}
	
	//update a note
	@PutMapping("/updateNote/{id}")
	public ResponseEntity<Note> updateNote(@PathVariable(value="id") Long noteId,@Valid @RequestBody Note noteDetails){
	
		Note note = noteService.getNoteById(noteId);
		if(note==null) {
			return ResponseEntity.notFound().build();
		}
		note.setTitle(noteDetails.getTitle());
		note.setContent(noteDetails.getContent());
		
		Note updateNote=noteService.addNote(note);
		return ResponseEntity.ok(updateNote);
	}
	
	//delete a note
	@DeleteMapping("/deleteNote/{id}")
	public ResponseEntity<Note> deleteNote(@PathVariable(value="id") Long noteId){
		
		Note note = noteService.getNoteById(noteId);
		if(note==null) {
			return ResponseEntity.notFound().build();
		}
		noteService.delete(note);
		return ResponseEntity.ok().build();
	}

	
}
