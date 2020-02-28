<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Pets Registration List</h1>
<form action = "editPetServlet" method="post">
Pet Type: <input type ="text" name = "store" value= "${itemToEdit.store}">
Pet Name: <input type = "text" name = "item" value= "${itemToEdit.item}">
<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Save Edited Item">
</form>

</body>
</html>