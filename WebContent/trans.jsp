<!DOCTYPE html>
<html>
<head>
<link href="/project/css/a.css" rel="stylesheet"type="text/css">

<meta charset="ISO-8859-1">
<title>TRANSACTION</title>
</head>
<body><ul>
<li><a href="">HOME</a></li>
<li><a href="/project/credit_agent.html">AGENT LOGIN</a></li>
<li><a href="/project/bcardlogin.html">B_CARD_DETAIL</a></li>
<li><a href="/project/user.html">REGISTRATION</a></li>
</ul>
<div align="center">
<fieldset>
<legend>TRANACTION</legend>
<form action="Tran" method="post">
<table><tr><td>

<input type="radio" name="status" value="deposit" checked/>deposit</td><td>


<tr>
<tr><td>BANK ACC NUMBER</td><td><input type="number"  name="accno2" />(top of the page)</td></tr>
<tr><td>MONEY</td><td><input type="number"name="money" min="100" max="999999"/></td></tr>
<tr><td>DATE  </td><td>   <input type="date" name="dat"/></td></tr>
</table>
<input type="submit" value="submit"/>
<input type="reset" value="reset"/>
</form>
<a href="/project/admin.html">admin</a>
</fieldset>
</div>

</body>
</html>