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
  <h1>Student Registration</h1>
  <form:form action="updateStudent" method="POST" 
  modelAttribute="studentRegistrationModel" >
  
  <table>
  			<tr>
				<td>Student ID :</td>
				<td><form:input path="studentregId" readonly="true" /></td>
			</tr>
			<tr>
				<td>FirstName :</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>LastName :</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>DOB :</td>
				<td><form:input path="dob" id="dob" /></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><form:input path="Gender" /></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Update"></td>
			</tr>
  </table>
  </form:form>
  
	<a href="viewStudentData">View Students Details</a>
	
</body>
</html>