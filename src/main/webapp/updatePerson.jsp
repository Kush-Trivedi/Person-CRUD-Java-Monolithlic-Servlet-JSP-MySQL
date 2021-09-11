<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body style='background-color: #008080'>
<%
	String cookieCreate = "";
	Cookie[] cookieArray = request.getCookies();
	if (cookieArray != null) {
		for (Cookie cookie : cookieArray) {
			if (cookie.getName().equals("personIdCookieUpdate")) {
				cookieCreate = cookie.getValue();
			}
		}
	}
%>
<h1>Update Person</h1>
	<form action="PersonController" method="post">
		<pre>
			Person ID:<input type="text" name="id" value="<%=cookieCreate%>"/><br /> 
			Person Name:<input type="text" name="name" /><br /> 
			Person Email:<input type="text" name="email" /> <br /> 
			<input type="hidden" name="action" value="update" />
			<input type="submit" value="Update Person" />
		</pre>
	</form>
</body>
</html>