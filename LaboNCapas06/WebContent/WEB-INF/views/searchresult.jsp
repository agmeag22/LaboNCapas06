    
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

			<table>
				<tr>
					<th>Name</th>
					<th>Last Name</th>
					<th>Age</th>
					<th>Status</th>
				</tr>
						<tr>
							<td>${studentresult.sName}</td>
							<td>${studentresult.lName}</td>
							<td>${studentresult.sAge}</td>
							<td>${studentresult.activoDelegate}</td>
						</tr>	
			</table>
	
			<h2>${message}</h2>
</body>
</html>