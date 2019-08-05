<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Bank transaction page</title>

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
		<br> <br>
	</p>

	<div>
		<hr width="1250" size="3" color="green">
	</div>


	<div>
		<font color="green" size="4"><i>
				<form method="post" action="ts">
					<table align="center" cellpadding="4" cellspacing="6"
						bgcolor="#ffffcc">
						<caption>Interbank transfer</caption>
						<tr align="justify">
							<td>To Receiver's Account Id. :</td>
							<td><input type="text" name="ra"></td>
						</tr>

						<tr align="justify">
							<td>Receiver's Name :</td>
							<td><input type="text" name="rn"></td>
						</tr>

						<tr align="justify">
							<td>From Sender's Account Id. :</td>
							<td>${acc}</td>
						</tr>

						<tr align="justify">
							<td>Amount :</td>
							<td><input type="text" name="am"></td>
						</tr>

						<tr align="justify">
							<td>Description's :</td>
							<td><input type="text" name="des"></td>
						</tr>

						<tr align="justify">
							<td></td>
							<td><input type="submit" name="Send"></td>
						</tr>
					</table>
				</form>
		</i></font>
	</div>

</body>
</html>