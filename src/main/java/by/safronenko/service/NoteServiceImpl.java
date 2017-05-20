package by.safronenko.service;


import by.safronenko.entities.Note;
import by.safronenko.repositories.NoteRepository;
import by.safronenko.utils.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("noteService")
@Transactional
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private CurrentUser currentUser;

    public List<Note> findAllNotes() {
        return noteRepository.findNotesByUser(currentUser.getCurrentUser());
    }

    public void addNote() {

    }

    public void deleteNote() {

    }

    public Note getNote(int id) {
        return null;
    }
}
