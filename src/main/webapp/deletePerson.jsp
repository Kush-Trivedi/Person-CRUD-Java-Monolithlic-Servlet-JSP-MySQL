<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String cookieCreate = "";
	Cookie[] cookieArray = request.getCookies();
	if (cookieArray != null) {
		for (Cookie cookie : cookieArray) {
			if (cookie.getName().equals("personIdCookieDelete")) {
				cookieCreate = cookie.getValue();
			}
		}
	}
%>
<h1>Delete Person </h1>
	<form action="PersonController" method="post">
		<pre>
			Person ID:<input type="text" name="id" value="<%=cookieCreate %>" /><br /> 
			<input type="hidden" name="action" value="delete" />
				      <input type="submit" value="Delete Person" />
		</pre>
	</form>

</body>
</html>