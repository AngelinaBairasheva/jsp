<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Read Users</title>
</head>
<body>
<center>
<h1>List of Users:</h1>
<jsp:useBean id="userBean" class="com.itis.UserBean" /> 
<table>
<%  
for(com.itis.UserBean.User user: userBean.getUserList()){
%>
<tr>
<td><%= user.getFirstname()%> </td>
<td><%= user.getLastname()%> </td>
<td><%= user.getAge() %></td>
</tr>
<% } %>
</table>
<p>Вывод с использованием JSTL-тегов:</p>
<c:set var="users" value="${userBean.getUserList()}" />
<table>
<c:forEach items="${users}" var="user">
<tr>
<td><c:out value="${user.firstname}"/></td>
<td><c:out value="${user.lastname}"/></td>
<td><c:out value="${user.age}"/></td>
</tr>
</c:forEach>
</table>
</center>
</body> 
</html>