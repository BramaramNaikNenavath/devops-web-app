<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<script type="text/javascript">
	
<%int status = response.getStatus();
			if (status == 401) {%>
	
<%}%>
	
</script>
</head>
<body>
	<form action="auth" method="post">
		<table style="with: 50%">

			<tr>
				<td>UserName</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>
		<input type="submit" value="Login" />
		<h3>
			New user ? <a href="register">Register</a>
		</h3>
	</form>
</body>
</html>