<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyBank welcomes you.</title>

<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

</head>

<body bgcolor="orange">

	<h2>
		<i>MyBank login page</i>
	</h2>

	<form method="post" action="log">
		<table align="center" cellpadding="4" cellspacing="4">
			<tr>
				<td><i>userName :</i></td>
				<td><input type="text" name="un" placeholder="Sam234@1"></td>
			</tr>
			<tr>
				<td><i>Password :</i></td>
				<td><input type="password" name="psw" placeholder="**********" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="SignIn" /></td>
			</tr>
		</table>
	</form>
</body>
</html>