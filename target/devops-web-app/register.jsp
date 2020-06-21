<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
	
</script>
</head>
<body>
	<h1>Register Form</h1>
	<form action="register" method="post">
		<table style="with: 50%">
			<tr>
				<td>UserName</td>
				<td><input type="text" name="userName" /></td>
			</tr>
			<tr>
				<td>Email-ID</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" name="cpassword" /></td>
			</tr>
			<tr>
				<td>Employee ID</td>
				<td><input type="text" name="empid" /></td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><input type="text" name="mobile" /></td>
			</tr>
		</table>
		<input type="submit" value="Register" />
		<h3>
			Already Registered ? <a href="login">Login</a>
		</h3>
	</form>
</body>
</html>