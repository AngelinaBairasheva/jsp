<%@ page import="java.util.Date" %>
<html>
<head>
<title>Using JavaBeans in JSP</title>
</head>
<body>
Hello World!<br>
<%
    out.println("Your IP address is " + request.getRemoteAddr());
%>
<br>
Today's date: <%=(new java.util.Date()).toLocaleString()%>
<center>
<h2>Using JavaBeans in JSP</h2>

    <jsp:useBean id="test" class="com.itis.TestBean" />

    <jsp:setProperty name="test" property="message" value="Hello JSP..." />

    <p>Got message....</p>

    <jsp:getProperty name="test" property="message" />
</center>
</body>
</html>
