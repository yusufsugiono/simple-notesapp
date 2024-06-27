package com.yusufsugiono.notesapp.pages;

import com.yusufsugiono.notesapp.models.Note;
import com.yusufsugiono.notesapp.services.NoteService;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

public class EditNote {
    @Persist
    @Property
    private Long noteId;

    @Property
    private String noteTitle;

    @Property
    private String noteBody;

    @Inject
    private NoteService noteService;

    @Inject
    private Logger logger;

    @InjectComponent
    private Form form;

    @Inject
    private Messages messages;

    Object onActivate(){
        if (this.noteId == null) {
            return Index.class;
        }
        return null;
    }

    Object onActivate(Long id){
        if (id == null){
            return Index.class;
        }
        try {
            this.noteId = id;
            Note oldNote = noteService.getNoteById(noteId);
            noteTitle = oldNote.getTitle();
            noteBody = oldNote.getBody();
            return null;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Index.class;
        }
    }

    void onValidateFromForm(){
        if (noteTitle == null || noteTitle.trim().equals("")){
            form.recordError(messages.get("noteTitle-required-message"));
        } else if (noteTitle.length() > 28) {
            form.recordError(messages.get("noteTitle-maxlength-message"));
        }

        if (noteBody == null || noteBody.trim().equals("")){
            form.recordError(messages.get("noteBody-required-message"));
        }

        if (!form.getHasErrors()) {
            Note note = new Note();
            note.setTitle(noteTitle);
            note.setBody(noteBody);
            noteService.updateNoteById(noteId, note);
        }
    }

    Object onSuccessFromForm(){
        this.noteId = null;
        return Index.class;
    }
}
