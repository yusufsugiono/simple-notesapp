package com.yusufsugiono.notesapp.services;

import com.yusufsugiono.notesapp.models.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteServiceImpl implements NoteService{
    private final List<Note> notesCache = new ArrayList<>();

    @Override
    public void addNote(Note note) {
        notesCache.add(note);
    }

    @Override
    public List<Note> getNotes() {
        return new ArrayList<>(notesCache);
    }

    @Override
    public Note getNoteById(Long id) {
        return notesCache.stream()
                .filter(n -> n.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateNoteById(Long id, Note note) {
        notesCache.stream()
                .filter(n -> n.getId().equals(id))
                .findFirst()
                .ifPresent(n -> {
                    n.setTitle(note.getTitle());
                    n.setBody(note.getBody());
                    System.out.println("Data Baru : " + n.toString());
                });
    }

    @Override
    public boolean deleteNote(Long id){
        try {
            Note note = notesCache.stream()
                    .filter(n -> n.getId().equals(id))
                    .findFirst()
                    .orElse(null);

            // if notes is exist, remove from the list
            if (note == null) {
                return false;
            }

            notesCache.remove(note);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
