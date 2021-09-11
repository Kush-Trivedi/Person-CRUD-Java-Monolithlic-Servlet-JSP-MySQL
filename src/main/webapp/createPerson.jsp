<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create</title>
</head>
<body style='background-color: #808080'>
<%
	String cookieCreate = "";
	Cookie[] cookieArray = request.getCookies();
	if (cookieArray != null) {
		for (Cookie cookie : cookieArray) {
			if (cookie.getName().equals("personNameCookieCreate")) {
				cookieCreate = cookie.getValue();
			}
		}
	}
%>
	<h1>Create Person</h1>
	<form action="PersonController" method="post">
		<pre>
			Person Name:<input type="text" name="name" value= "<%=cookieCreate%>" /><br /> 
			Person Email:<input type="text" name="email" /> <br /> 
			<input type="hidden" name="action" value="create" />
			<input type="submit" value="Create Person" />
		</pre>
	</form>
</body>
</html>