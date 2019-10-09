<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/project/css/a.css" rel="stylesheet"type="text/css">

<style type="text/css">
fieldset{
background-image:linear-gradient(green,blue);
  position:relative;
  top:150px;
  margin-left:450px;
  margin-right:450px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CREDIT CARD REGISTRATION</title>
</head>
<body><ul>
<li><a href="">HOME</a></li>
<li><a href="/project/credit_agent.html">AGENT LOGIN</a></li>
<li><a href="/project/bcardlogin.html">B_CARD_DETAIL</a></li>
<li><a href="/project/user.html">REGISTRATION</a></li>
</ul>
<div align="center">
<fieldset id="reg">
<legend>CREDIT REGISTRATION</legend>
<h1>WELCOME</h1><%String namehe=request.getParameter("name45");
out.println(namehe.toUpperCase());
%>
<br>B_CARD_NUMBER:
<% String bcardhe=request.getParameter("bcard45");
out.println(bcardhe);%>

<form action="Creditreg" method="post" >
<table><tr>
<tr><td>NAME</td> <td>         <input type="text" name="name87" readonly value=<% out.println(namehe);  %>></td></tr>
<tr><td>B CARD NUMBER:</td><td>          <input type="text" name="bcard87" readonly value=<%= request.getParameter("bcard45") %>></td></tr>

<tr><td>USER ID:</td> <td>         <input type="text" name="user101" /></td></tr>
<tr><td>PASSWORD</td><td>          <input type="password" name="pass101"/></td></tr>
<tr><td>CONFIRM PASSWORD</td><td>   <input type="password" name="pass102"/></td></tr>

</table>


<input type="submit" value="register"/>
<input type="reset" value="reset"/>
</form>

</fieldset>

</div>
</body>
</html>