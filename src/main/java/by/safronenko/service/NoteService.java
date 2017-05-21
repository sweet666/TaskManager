package by.safronenko.service;


import by.safronenko.entities.Note;

import java.util.List;

public interface NoteService {

    List<Note> findAllNotes();

    void addNote(Note note);

    void  deleteNote(int id);

    Note getNote(int id);
}
