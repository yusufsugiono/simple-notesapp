package com.yusufsugiono.notesapp.pages;

import com.yusufsugiono.notesapp.models.Note;
import com.yusufsugiono.notesapp.services.NoteService;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

public class ReadNote {
    @Inject
    private NoteService noteService;

    @Inject
    private Logger logger;

    @Property
    private Long id;

    @Property
    private Note note;

    void onActivate(Long id){
        this.id = id;
        this.note = noteService.getNoteById(id);
    }

    Long onPassivate(Long id){
        return id;
    }

    Object onDelete(Long id){
        try {
            noteService.deleteNote(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return Index.class;
    }
}
