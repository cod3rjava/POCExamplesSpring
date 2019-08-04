<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font color='green'>${succMsg}</font>
<font color='red'>${failMsg}</font>
	<h2>User Account Creation</h2>
	<form:form action="createStudentReg" method="POST"
	modelAttribute="studentRegModel">
	<table>
	<tr>
		  <td>First Name :</td>
		<td><form:input path="firstName"/></td>
	</tr>
	
	<tr>
		  <td>Last Name :</td>
		<td><form:input path="lastName"/></td>
	</tr>
	
	<tr>
		  <td>Date of Birth :</td>
		<td><form:input path="dob"/></td>
	</tr>
	<tr>
		  <td>Gender :</td>
		<td><form:radiobuttons items="${genders}" path="gender" /></td>
	</tr>
	
	<tr>
		<td><input type="submit" value="Reset"/></td>
		<td><input type="submit" value="Create Student Registration" id="createRegBtn"/></td>
	</tr>
	
	
	</table>
	<a href="displayStudentDetails">View Student Details</a>
	</form:form>
	
</body>
</html>