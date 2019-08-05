<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mybank</title>

<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

</head>
<body bgcolor="#cccc66">
	<div>
		<table align="left">
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

		<table align="right">
			<tr align="justify">
				<td><font color="black" size="4"> <i>Your AccountNo.
							is: ${acc}</i>
				</font></td>
			</tr>
			<tr align="right">
				<td>
					<form action="lgt">
						<input type="submit" value="Logout" />
					</form>
				</td>
			</tr>
		</table>
	</div>

	<div>
		<hr width="1250" size="3" color="green">
	</div>

	<div>
		<table align="center" cellpadding="6" cellspacing="6">
			<tr>
				<td>
					<form action="vb">
						<input type="submit" value="Check Balance" />
					</form>
				</td>

				<td>
					<form action="tpg">
						<input type="submit" value="Amount transfer" />
					</form>
				</td>

				<td>
					<form action="des">
						<input type="submit" value="Statements" />
					</form>
				</td>
			</tr>

		</table>
	</div>
</body>
</html>