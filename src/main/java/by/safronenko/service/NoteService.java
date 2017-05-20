package by.safronenko.service;


import by.safronenko.entities.Note;

import java.util.List;

public interface NoteService {

    List<Note> findAllNotes();

    void addNote();

    void  deleteNote();

    Note getNote(int id);
}
