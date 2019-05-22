<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--<h1>${message}</h1>-->
	
	<form action = "${pageContext.request.contextPath}/formSearch" method="POST">
		<input type = "number" name = "cStudent" path = "cStudent"/>
		<input type = "submit" value = "Search"/>
	</form>
	
	<table>
		<tr>
			<th>Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Status</th>
		</tr>
			<c:forEach items="${students}" var="students">
				<tr>
					<td>${students.sName}</td>
					<td>${students.lName}</td>
					<td>${students.sAge}</td>
					<td>${students.activoDelegate}</td>
					<td><form:form action = "${pageContext.request.contextPath}/formUpdate/${students.cStudent}" method = "post" >
					<input type = "submit"  value = "Edit">
						</form:form></td>
					<td><form:form action = "${pageContext.request.contextPath}/delete/${students.cStudent}" method = "post" >
					<input type = "submit"  value = "Delete user">
					</form:form></td>
				</tr>	
			</c:forEach>
	</table>
	<form action = "${pageContext.request.contextPath}/save" method = "post">
	<input type = "submit"  value = "Add a new user">
	</form>
	</body>
</html>