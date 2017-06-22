
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
h2 {text-align : center }
div {text-align : center}
body {background-color : powderblue}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Displaying Records</title>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<div>
<table border=1>
        <thead>
            <tr>
                <th>Book Id</th>
                <th>Title</th>
                <th>Author Name</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
        
            <c:forEach items="${List}" var="row">
                <tr>
                    <td><c:out value="${row.book_id}" /></td>
                    <td><c:out value="${row.title}" /></td>
                    <td><c:out value="${row.author}" /></td>
                    <td><c:out value="${row.price}" /></td>
                   
                </tr>
            </c:forEach>
        </tbody>
    </table><br><br><br>

<a href = "index.html">Return to Home Page</a>
</div>
</body>
</html>