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
<title>Update Book Database</title>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<h2> ${method} a particular Record in Database</h2>
<div>
<form method = "post" action = "HandleServlet">
Enter Book ID : <input type = "text" id = "bid" name = "bid"/><br><br>
<c:if test="${method eq 'Update'}">
Enter New Price :<input type = "text" id = "p_val" name = "p_val"><br><br>
</c:if>
<input type = "Submit" id = ${method} name = ${method} value = ${method} >

</form><br><br><br>


<a href = "index.html">Return to Home Page</a>
</div>
</body>
</html>