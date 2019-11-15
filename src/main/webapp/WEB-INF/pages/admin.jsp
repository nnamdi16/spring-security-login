<%--
  Created by IntelliJ IDEA.
  User: nnamdi
  Date: 11/12/19
  Time: 8:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <title>Hello Admin </title>
</head>
<body>
  <h1>Title: ${title}</h1>
  <h1>Message: ${message}</h1>
<c:if test="${pageContext.request.userPrincipal.name}">
  <h2>Welcome: ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/logout"/> ">Logout</a> </h2>
</c:if>
</body>
</html>
