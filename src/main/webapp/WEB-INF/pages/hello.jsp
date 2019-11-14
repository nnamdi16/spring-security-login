<%--
  Created by IntelliJ IDEA.
  User: nnamdi
  Date: 11/12/19
  Time: 8:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Spring Security</title>
</head>
<body>
  <h1>Title: ${title}</h1>
  <h1>Message: ${message}</h1>
<h4><a href="admin">Admin Page</a> || <a href="<c:url value="/logout" />">Logout</a>
</h4>
</body>
</html>
