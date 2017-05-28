package by.safronenko.controllers;

import by.safronenko.entities.Note;
import by.safronenko.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping("/notes")
    public String listNotes(Model model) {

        List<Note> noteList = noteService.findAllNotes();
        model.addAttribute("noteList", noteList);

        return "notes";
    }

    @RequestMapping(value = "/addnote", method = RequestMethod.POST)
    public String addTask(@ModelAttribute("note") Note note) {

        noteService.addNote(note);

        return "redirect:/notes";
    }

    @RequestMapping(value = "/notes/delete/{noteId}")
    public String deleteNote(@PathVariable("noteId") int noteId) {

        noteService.deleteNote(noteId);

        return "redirect:/notes";
    }

    @RequestMapping(value = "/notes/get/{noteId}")
    public ModelAndView getNote(@PathVariable("noteId") int noteId) {
        ModelAndView modelAndView = new ModelAndView();
        Note note = noteService.getNote(noteId);
        modelAndView.addObject("note", note);
        modelAndView.setViewName("editNote");

        return modelAndView;
    }

    @RequestMapping(value = "/notes/get/update/{noteId}", method = RequestMethod.POST)
    public String updateTask(@ModelAttribute("note") Note note, @PathVariable("noteId") int noteId) {
        note.setId(noteId);
        noteService.addNote(note);

        return "redirect:/notes";
    }


}
