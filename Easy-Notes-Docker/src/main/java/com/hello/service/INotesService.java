package com.hello.service;

import java.util.List;

import com.hello.model.Note;

public interface INotesService {

	List<Note> getAllNotes();
	Note addNote(Note note);
	Note getNoteById(Long id);
	void delete(Note note);
}
