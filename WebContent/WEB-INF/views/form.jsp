<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new user</title>
</head>
<body>

	<form:form action = "${pageContext.request.contextPath}/formData" method = "POST" modelAttribute = "student">
	<form:input type="hidden" path="cStudent" />
	<label>Name: </label>
	<form:input type = "text" name = "sname" path = "sName"/><br>
	
	<label>Last name: </label>
	<form:input type = "text" name = "lname" path = "lName"/><br>
	
	<label>Age: </label>
	<form:input type = "number" name = "age" path = "sAge"/><br>
	
	<Label>Student status</Label><br>
	<form:radiobutton name = "status" path="bActivo" value = "true"/><label>Active</label><br> 
	<form:radiobutton name = "status" path="bActivo" value = "false"/><label>Inactive</label><br> 
	
	<input type = "submit" value = "Save">
	
	</form:form>
</body>
</html>