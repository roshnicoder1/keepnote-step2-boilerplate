package com.stackroute.keepnote.controller;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stackroute.keepnote.dao.NoteDAO;
import com.stackroute.keepnote.model.Note;


/*
 * Annotate the class with @Controller annotation.@Controller annotation is used to mark 
 * any POJO class as a controller so that Spring can recognize this class as a Controller
 */
@Controller
public class NoteController {
	@Autowired
	private NoteDAO noteDao;
	
	@Autowired
	private Note note;
	
	public NoteController() {
		super();
	}

	public NoteController(NoteDAO noteDao) {
		this.noteDao=noteDao;
	}

	
	@GetMapping(value= "/")
	public String indexPage(ModelMap model) {
		model.addAttribute("noteList", noteDao.getAllNotes());
		return "index";
	}
	
	
	@PostMapping(value="/add")
	public String addNote(@ModelAttribute("note") Note note, ModelMap model) {

		if (note.getNoteContent().isEmpty()) {
			model.addAttribute("errorMessage", "Fields should not be empty");
			return "index";
		} else {
			note.setCreatedAt(LocalDateTime.now());
			noteDao.saveNote(note);
			return "redirect:/";
		}			
		}

	@RequestMapping("/delete")
	public String deleteNote(@RequestParam int noteId, ModelMap model) {
		noteDao.deleteNote(noteId);
		return "redirect:/";

	}
	@RequestMapping(value = "/updateNote")
	public String updateNote(@RequestParam int noteId, ModelMap model) {		
		model.addAttribute("note", noteDao.getNoteById(noteId));		
		return "update";
	}

	@RequestMapping(value = "/update")
	public String update(@ModelAttribute("note") Note note, ModelMap model) {
		note.setCreatedAt(LocalDateTime.now());
		noteDao.UpdateNote(note);
		return "redirect:/";
	}

	/*
	 * From the problem statement, we can understand that the application requires
	 * us to implement the following functionalities.
	 * 
	 * 1. display the list of existing notes from the persistence data. Each note
	 * should contain Note Id, title, content, status and created date. 
	 * 2. Add a new note which should contain the note id, title, content and status. 
	 * 3. Delete an existing note 
	 * 4. Update an existing note
	 * 
	 */

	/*
	 * Autowiring should be implemented for the NoteDAO.
	 * Create a Note object.
	 * 
	 */

	/*
	 * Define a handler method to read the existing notes from the database and add
	 * it to the ModelMap which is an implementation of Map, used when building
	 * model data for use with views. it should map to the default URL i.e. "/index"
	 */

	/*
	 * Define a handler method which will read the NoteTitle, NoteContent,
	 * NoteStatus from request parameters and save the note in note table in
	 * database. Please note that the CreatedAt should always be auto populated with
	 * system time and should not be accepted from the user. Also, after saving the
	 * note, it should show the same along with existing messages. Hence, reading
	 * note has to be done here again and the retrieved notes object should be sent
	 * back to the view using ModelMap This handler method should map to the URL
	 * "/add".
	 */

	/*
	 * Define a handler method which will read the NoteId from request parameters
	 * and remove an existing note by calling the deleteNote() method of the
	 * NoteRepository class.This handler method should map to the URL "/delete".
	 */

	/*
	 * Define a handler method which will update the existing note. This handler
	 * method should map to the URL "/update".
	 */

}
