package com.hello.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hello.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{
	List<Note> findByTitle(String title);
}
