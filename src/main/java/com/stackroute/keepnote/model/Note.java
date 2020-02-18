package com.stackroute.keepnote.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/*
 * The class "Note" will be acting as the data model for the note Table in the database. Please
 * note that this class is annotated with @Entity annotation. Hibernate will scan all package for 
 * any Java objects annotated with the @Entity annotation. If it finds any, then it will begin the 
 * process of looking through that particular Java object to recreate it as a table in your database.
 */
@Entity
@Component
@Table(name="NoteData")
public class Note {
	@Id
	@Column(name="noteId")
	private int noteId;
	
	@Column(name="noteTitle")
	private String noteTitle;
	@Column(name="noteContent")
	private String noteContent;
	@Column(name="noteStatus")
	private String noteStatus;
	@Column(name="createdAt")
	private LocalDateTime createdAt;

	public Note() {
		super();

	}
	




public Note(int noteId, String noteTitle, String noteContent, String noteStatus, LocalDateTime createdAt) {
		super();
		this.noteId = noteId;
		this.noteTitle = noteTitle;
		this.noteContent = noteContent;
		this.noteStatus = noteStatus;
		this.createdAt = createdAt;
	}





//	public Note(int i, String string, String string2, String string3, LocalDateTime localDate) {
//	}

	public int getNoteId() {

		return noteId ;
	}

	public String getNoteTitle() {

		return noteTitle;
	}

	public String getNoteContent() {

		return noteContent;
	}

	public String getNoteStatus() {

		return noteStatus;
	}
	

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}





	public void setNoteId(int parseInt) {
		this.noteId=parseInt;

	}

	public void setNoteTitle(String parameter) {
		this.noteTitle=parameter;

	}

	public void setNoteContent(String parameter) {
		this.noteContent=parameter;

	}

	public void setNoteStatus(String parameter) {
		this.noteStatus=parameter;

	}

	public void setCreatedAt(LocalDateTime now) {
		this.createdAt=now;

	}

}
