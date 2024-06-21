package com.yusufsugiono.notesapp.pages;

import com.yusufsugiono.notesapp.models.Note;
import com.yusufsugiono.notesapp.services.NoteService;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddNote {
    @Property
    private String noteTitle;

    @Property
    private String noteBody;

    @Inject
    private NoteService noteService;

    void onValidateFromForm(){
        String noteId = String.valueOf(new Date().getTime());
        String pattern = "EEE, dd MMM yyyy, HH.mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String createdAt = simpleDateFormat.format(new Date());

        Note note = new Note();
        note.setId(Long.valueOf(noteId));
        note.setTitle(noteTitle);
        note.setBody(noteBody);
        note.setCreatedAt(createdAt);

        noteService.addNote(note);
    }

    Object onSuccessFromForm(){
        return Index.class;
    }
}
