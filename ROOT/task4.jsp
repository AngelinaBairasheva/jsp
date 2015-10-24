<html>
<head>
<title>Using GET and POST Method to Read Form Data</title>
</head>
<body>
<form action="task4.jsp" method="POST">
Firstname: <input type="text" name="first_name"><br />
Lastname: <input type="text" name="last_name" /><br />
<input type="submit" value="Submit" />
</form>
<% if (request.getParameter("first_name")!=null &&request.getParameter("last_name")!=null){%>
<p>Firstname: <%= request.getParameter("first_name")%></p>
<p>Lastname: <%= request.getParameter("last_name")%></p>
<%}%>
</body>
</html>