<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Bank</title>

<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

</head>
<body bgcolor="orange">

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
	</div>
	<div>
		<hr width="1250" size="2" color="green">
	</div>

	<div>
		<table align="center" bgcolor="#ffffcc" cellpadding="4"
			cellspacing="10">
			<tr>
				<td align="center"><font color="green" size="4"> Amount
						transfered successfully..!!<br> <br> Your Transaction Id
						is : ${transac_id}<br> <br> Amount is transfered to
						account id: ${racc}<br> <br> Your remaining amount is
						Rs: ${current_bal}
				</font></td>
			</tr>
		</table>
	</div>

</body>
</html>