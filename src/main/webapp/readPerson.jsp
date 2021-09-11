<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read</title>
</head>
<body style='background-color: #808000'>
<%
	String cookieCreate = "";
	Cookie[] cookieArray = request.getCookies();
	if (cookieArray != null) {
		for (Cookie cookie : cookieArray) {
			if (cookie.getName().equals("personIdCookieRead")) {
				cookieCreate = cookie.getValue();
			}
		}
	}
%>
<h1>Read or Search Person Details</h1>
	<form action="PersonController" method="post">
		<pre>
			Person ID:<input type="text" name="id" value="<%=cookieCreate %>" /><br /> 
			<input type="hidden" name="action" value="read" />
				      <input type="submit" value="Search Person" />
		</pre>
	</form>
</body>
</html>