package com.yusufsugiono.notesapp.services;

import com.yusufsugiono.notesapp.models.Note;

import java.util.List;

public interface NoteService {
    public void addNote(Note note);
    public List<Note> getNotes();
    public Note getNoteById(Long id);
    public void updateNoteById(Long id, Note note);
    public boolean deleteNote(Long id);
}
