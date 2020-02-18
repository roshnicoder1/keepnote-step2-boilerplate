<!-- <!DOCTYPE html>
<html lang="en">

<head>
<title>Keep-Board</title>
</head>

<body>
	Create a form which will have text boxes for Note title, content and status along with a Add 
		 button. Handle errors like empty fields.  (Use dropdown-list for NoteStatus)

	display all existing notes in a tabular structure with Title,Content,Status, Created Date and Action
</body>

</html> -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Keep-Board</title>
</head>
<body>
	
<form action="add" method="post">
<table>

<tr>
<td><label>Note id</label></td>
<td><input type="text" name="noteId"/></td>
</tr>
<tr>
<td><label>Note Title</label></td>
<td><input type="text" name="noteTitle"/></td>
</tr>
<tr>
<td><label>Note Content</label></td>
<td><input type="text" name="noteContent"/></td>
</tr>
<tr>
<td><label>Note Status</label></td>
<td><input type="text" name="noteStatus"/></td>
</tr>
<!-- <tr>
<td><label>Note Date</label></td>
<td><input type="text" name="createdAt"/></td>
</tr> --> 
<tr>
<td><input type="submit" value="Add Note" ></td>
</tr>

</table>
</form>

<table border="1">
<tr>
<td>Note id</td>
<td>Note Title</td>
<td>Note Content</td>
<td>Note Status</td>
<td>Note Created Time</td>
</tr>
<c:forEach items="${noteList}" var="note"> 
<tr>
<td><input type="text" name="noteId" value="${note.noteId}"/></td>
<td>${note.noteTitle}</td>
<td>${note.noteContent}</td>
<td>${note.noteStatus}</td>
<td>${note.createdAt}</td>
<td><form action="updateNote" method="post">
						<input type="hidden" id="noteId" name="noteId"
							value="${note.noteId}" />
						<button type="submit">Update</button>
					</form></td>
				<td><form action="delete" method="post">
						<input type="hidden" id="noteId" name="noteId"
							value="${note.noteId}" />
						<button type="submit">Delete</button>
					</form></td>
			</tr>
			<br />
</c:forEach>
</table>
</body>
</html>

