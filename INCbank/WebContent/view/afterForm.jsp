<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Redirected page...</title>

<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

</head>
<body bgcolor="orange">
	<center>
		<div>
			<p>
				Welcome ${firstName} <br> <br> Your Account No. is :
				${accntno}
			</p>
		</div>
		<form action="lg">
			<input type="submit" value="Login here" />
		</form>
	</center>
</body>
</html>