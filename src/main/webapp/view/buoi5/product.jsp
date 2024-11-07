<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="">
    Tên: <input name="ten"/>
    <button type="submit">Search</button>
</form>
<br/>
<button><a href="/category/view-add">Add Cate</a></button>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Cate Code</th>
        <th>Cate name</th>
        <th>Product code</th>
        <th>Product name</th>
        <th>Price</th>
        <th>Description</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <%-- Hien thi stt => varStatus     --%>
    <c:forEach items="${lists}" var="p" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${p.id1}</td>
            <td>${p.category1.categoryCode}</td>
            <td>${p.category1.categoryName}</td>
            <td>${p.productCode}</td>
            <td>${p.productName}</td>
            <td>${p.productName}</td>
            <td>${p.price}</td>
            <td>${p.description}</td>
            <td>
               </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
