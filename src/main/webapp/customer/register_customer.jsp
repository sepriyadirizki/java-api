<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/cust" method="post">
		<table>
			<tr>
				<td>First Name</td>
				<td>:</td>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td>:</td>
				<td><input type="text" name="lastName"></td>

			</tr>
			<tr>
				<td>Birth Date</td>
				<td>:</td>
				<td><input type="text" name="birthDate"></td>

			</tr>
			<tr>
				<td><button type="submit">Submit</button></td>
		</table>
	</form>
</body>
</html>