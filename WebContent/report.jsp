<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
fieldset{
background-image:url("/project/credit.jpg");
  position:relative;
  top:150px;
  margin-left:450px;
  margin-right:450px;
}
body{
color:gold;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>report generation</title>
</head>
<body>
<fieldset>
<h1>REPORT</h1>
<table>
<tr><td>CARD NUMBER:</td><td><%=request.getAttribute("cno") %></td><td></td></tr>
<tr><td>NAME:</td><td><%=request.getAttribute("nameofc") %></td><td></td></tr>
<tr><td>DOB:</td><td><%=request.getAttribute("ageofc") %></td><td></td></tr>
<tr><td>ADDRESS:</td><td><%=request.getAttribute("useradd") %></td><td></td></tr>
</table>

   
</fieldset>
</body>
</html>