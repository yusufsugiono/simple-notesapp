package com.yusufsugiono.notesapp.pages;


import com.yusufsugiono.notesapp.models.Note;
import com.yusufsugiono.notesapp.services.NoteService;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

import java.util.List;

public class Index {
    @Inject
    private NoteService noteService;

    @Inject
    private Logger logger;

    @Property
    private Note note;

    @Property
    private List<Note> notes;

    void setupRender() {
        this.notes = noteService.getNotes();
        logger.info("Notes:" + this.notes.toString());
    }
}
