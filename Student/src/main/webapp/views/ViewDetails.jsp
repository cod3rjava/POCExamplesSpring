<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<font color="red">View User Details</font>

	<table border="1" id="studentTable">
		<thead>

			<tr>
				<th>S.No</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>DOB</th>
				<th>Gender</th>
				<th>Address</th>
				<th>Action</th>


			</tr>

		</thead>
		<tbody>
			<c:forEach items="${StudentRegistrationModel}" var="stuData"
				varStatus="index">

				<tr>
					<td><c:out value="${index.count}"></c:out></td>
					<td><c:out value="${stuData.firstName}"></c:out></td>
					<td><c:out value="${stuData.lastName}"></c:out></td>
					<td><c:out value="${stuData.dob}"></c:out></td>
					<td><c:out value="${stuData.gender}"></c:out></td>
					<td><c:out value="${stuData.address}"></c:out></td>
					
					<td>
					<a href="editAccount?id=${stuData.studentregId}">Edit || </a>
					<a href="deleteAccount?id=${stuData.studentregId}">Delete</a>
					</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
	<a href="studentRegistrationCreate">View Student Details</a>

</body>
</html>