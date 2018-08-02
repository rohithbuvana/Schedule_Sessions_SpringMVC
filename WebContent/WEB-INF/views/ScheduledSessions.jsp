<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home Page</title>
<style>
#link
{
	background:none;
     color:blue;
     text-decoration:underline;
     border:none; 
     padding:0;
     cursor: pointer;
}
</style>
</head>
<body>
	<div align="center">
		<h1>Scheduled Sessions</h1>
		<table>
			<tr>
				<td><b>Session Name</b></td>
				<td><b> Duration(Days)</b></td>
				<td><b> Faculty</b></td>
				<td><b> Mode</b></td>
			</tr>
			<!-- For Each loop is used to iterate through all the list of courses that are fetched from the database -->
			<c:forEach var="CourseList" items="${course}">
			<!-- A from is created individually for each courses to avoid the conflict of fetching all the course names in the list of courses of available when the button is clicked for a particular courses  -->
				<form:form action="enroll" method="post" >
					<tr>
					
						<td><label>${ CourseList.name }</label></td>
						<td><label> ${ CourseList.duration }</label></td>
						<td><label> ${ CourseList.faculty }</label></td>
						<td><label> ${ CourseList.mode1 }</label></td>
						<td><input id="link" type="submit" value="Enroll Me" /></td>
						<!-- A hidden input type is specified to pass the name of the course in which the user is enrolled to the success page of the webapp-->
					<td><input name="name" value="${ CourseList.name }" type="hidden"/></td>
					</tr>
				</form:form>
			</c:forEach>

		</table>
	</div>
</body>
</html>