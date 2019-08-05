<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exception occured</title>

<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

</head>
<body bgcolor="#ffffcc">
	<div>
		<center>
			<font color="green" size="+3"> <i> Sorry!! Some Exception
					Occurred. </i>
			</font>
		</center>

		<table align="center">
			<tr>
				<td><font color="green" size="+3"> <i> Go back to
							login : </i>
				</font></td>
				<td>
					<form action="lg">
						<input type="submit" value="Click here" />
					</form>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>