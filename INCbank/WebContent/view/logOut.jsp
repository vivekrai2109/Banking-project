<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
    
   session.setAttribute("userId", null); // in your logout.jsp page 
    
%>
<title>Thank you..Visit again</title>
</head>
<body bgcolor="#ffffcc">

	<div>
		<p>
		<hr width="1250" size="3">
		</p>
	</div>

	<div>
		<table align="center">
			<tr>
				<td align="center"><font color="green" size="+2"> Thank
						you for Visiting <i>INC</i>,<br> <br> Hope you enjoyed
						the banking service, do visit again..
				</font></td>
			</tr>
			<tr>
				<td align="right"><img
					src="D:\samfiles\Eclipse programs\mybank\WebContent\image\logo of INC.jpg" />
					&copy; <i>All Rights Reserved.</i></td>
			</tr>
		</table>
	</div>

	<div>
		<p>
		<hr width="1250" size="3" />
		</p>
	</div>

</body>
</html>