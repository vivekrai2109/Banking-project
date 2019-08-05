<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>

<%
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>

</head>
<body bgcolor="orange">
	<div>
		<h2>
			<i>Welcome to MyBank</i>
		</h2>
	</div>
	<div>
		<hr width="1250" size="2" color="green">
	</div>

	<div>
		<h2>
			<%
				String msg = (String) request.getAttribute("msg");
				if (msg != null) {
			%>
			<%=msg%>
			<%
				}
			%>
			${msg}
		</h2>
	</div>

	<div>
		<font color="green" size="4"><i>
				<form method="post" action="reg">
					<table align="center" bgcolor="#ffffcc" cellspacing="9"
						cellpadding="6">

						<caption>Registration Form</caption>

						<tr align="justify">
							<td>FirstName:</td>
							<td><input type="text" Name="fn"
								onchange="var pattern=/[a-z]/; if (pattern.test(this.value))alert('Please enter in caps')"></td>
						</tr>

						<tr align="justify">
							<td>LastName:</td>
							<td><input type="text" Name="ln"></td>
						</tr>

						<tr align="justify">
							<td>DOB:</td>
							<td><input type="text" Name="db"></td>
						</tr>

						<tr align="justify">
							<td>UserId:</td>
							<td><input type="text" Name="un"
								onchange="if (this.value.length&lt;5) alert(' Please enter userId more than 8 or 10 chacrecters.')"></td>
						</tr>

						<tr>
							<td>Address:</td>
							<td><input type="text" Name="add"></td>
						</tr>

						<tr align="justify">
							<td>Phone No:</td>
							<td><input type="text" Name="ph"
								onchange="if (this.value.length&lt;10) alert(' Please enter your mobileno correctly.')"></td>
						</tr>

						<tr align="justify">
							<td>Account Type:</td>
							<td>Saving:<input type="Radio" Name="ac1">&nbsp;&nbsp;
								Current:<input type="Radio" Name="ac1"></td>
						</tr>

						<tr align="justify">
							<td>Gender:</td>
							<td>Female:<input type="Radio" Name="G2">&nbsp;&nbsp;
								Male:<input type="Radio" Name="G2"></td>
						</tr>

						<tr align="justify">
							<td>Password:</td>
							<td><input type="password" Name="psw" placeholder="*******"
								onchange="if (this.value.length&lt;8) alert(' Please enter Password more than 8 or 10 chacrecters.')"></td>
						</tr>

						<tr align="justify">
							<td>Confirm Password:</td>
							<td><input type="password" Name="psw1" placeholder="*******"
								onchange="if (this.value.length&lt;8) alert(' Please enter Passmord than 8 or 10 chacrecters.')"></td>
						</tr>

						<tr align="justify">
							<td></td>
							<td align="justify"><input type="submit" value="Register">
								<input type="reset" value="Reset"></td>
						</tr>
					</table>
				</form>
		</i> </font>
	</div>
</body>

</html>