<%--
  Created by IntelliJ IDEA.
  User: hangnt169
  Date: 6/11/24
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${applicationScope.a}
<%
    // Thiết lập giá trị trong pageContext
    pageContext.setAttribute("message", "Hello from PageContext!");

    // Lấy giá trị từ pageContext
    String message = (String) pageContext.getAttribute("message");
%>

<p>${message}</p> <!-- Hiển thị giá trị message -->
</body>
</html>
