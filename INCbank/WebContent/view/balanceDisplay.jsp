<%@page import="com.jspiders.app.controller.LoginController"%>
<%@page import="com.jspiders.app.dto.BankDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>View Balance</title>

<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

</head>
<body bgcolor="#cccc66">
	<div>
		<table align="left" bgcolor="#ffffcc">
			<tr>
				<td align="center">
					<form action="hom">
						<input type="image" alt="INC"
							src="D:\samfiles\Eclipse programs\mybank\WebContent\image\logo of INC.jpg" />
					</form>
				</td>
				<td align="center"><font color="green" size="4"> <i>
							${firstName} ${lastName} </i>
				</font></td>
			</tr>
		</table>
	</div>

	<%
		BankDTO dto = new BankDTO();
	%>

	<div>
		<table align="right" bgcolor="#ffffcc">
			<tr align="center">
				<td>
					<form action="lgt">
						<input type="submit" value="Logout" />
					</form>
				</td>
			</tr>
		</table>
	</div>

	<p>
		<br>
	</p>
	<div>
		<hr width="1250" color="black" size="3" noshade="noshade">
	</div>

	<p>
		<br> <br>
	</p>
	<div>
		<table align="center" bgcolor="#ffffcc" bordercolor="brown"
			cellpadding="6" cellspacing="6">
			<tr>
				<td><font size="5" color="green"> Your Account Id :
						${acc} </font></td>
			</tr>
			<tr>
				<td><font size="5" color="green"> Your Balance: ${bal} </font>
				</td>
			</tr>
		</table>
	</div>











</body>
</html>