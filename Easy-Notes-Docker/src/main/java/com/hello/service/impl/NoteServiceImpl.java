package com.hello.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hello.model.Note;
import com.hello.repository.NoteRepository;
import com.hello.service.INotesService;

@org.springframework.stereotype.Service

public class NoteServiceImpl implements INotesService {

	private final static Logger LOG = LoggerFactory.getLogger(NoteServiceImpl.class);

	@Autowired
	NoteRepository noteRepository;

	@Override
	public List<Note> getAllNotes() {
		List<Note> getNotes = noteRepository.findAll();
		LOG.debug("All Notes:{}", getNotes);
		return getNotes;
	}

	@Override
	public Note addNote(Note note) {
		Note save = noteRepository.save(note);
		LOG.debug("Saved Note:{}", note);
		return save;
	}

	@Override
	public Note getNoteById(Long id) {
		Note note=noteRepository.findOne(id);
		
		return note;
	}

	@Override
	public void delete(Note note) {
	 noteRepository.delete(note);;
	}

}
