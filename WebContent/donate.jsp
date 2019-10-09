<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*,java.sql.*,javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
    position: relative;
}

img.user {
    width: 20%;
    border-radius: 50%;
}

.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

.modal {
    display: block; 
    position: fixed; 
    z-index: 1; 
    left: 70px;
    right:80px;
    bottom:70px;
    top: 200px;
    width: 70%; 
    height: 70%; 
    overflow: auto; 
    background-color: rgb(0,0,0); 
    background-color: rgba(0,0,0,0.4); 
    padding-top: 20px;
}

.modal-content {
    background-color: #fefefe;
    margin: 1% auto 5% auto; 
    border: 1px solid #888;
    width: 40%; 
    bottom:20px;
}

.close {
    position: absolute;
    right: 25px;
    top: 0;
    color: #000;
    font-size: 35px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: red;
    cursor: pointer;
}

.animate {
    -webkit-animation: animatezoom 0.6s;
    animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
    from {-webkit-transform: scale(0)} 
    to {-webkit-transform: scale(1)}
}
    
@keyframes animatezoom {
    from {transform: scale(0)} 
    to {transform: scale(1)}
}

@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
<head>
<link href="/project/css/a.css" rel="stylesheet"type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HELPING MIND</title>
</head>
<body>
<ul>
<li><a href="">HOME</a></li>
<li><a href="/project/credit_agent.html">AGENT LOGIN</a></li>
<li><a href="/project/bcardlogin.html">B_CARD_DETAIL</a></li>
<li><a href="/project/user.html">REGISTRATION</a></li>
</ul>
THANK YOU FOR HELPING HANDS
<div align="center"><h1>Mr/Mrs :  
<%= request.getSession().getAttribute("dname").toString().toUpperCase() %></h1></div>

LIST OF POOR PEOPLE BASED ON BANK ACCONT TRANSACTION
<div id="id01" class="modal">
  
  <form class="modal-content animate" action="servlet/Poor" method="post">
  <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="/project/user.png" alt="user" class="user">
    </div>
    <div align="center">
    <b><%= request.getSession().getAttribute("dname").toString().toUpperCase() %> </b>
    </div>
    <div class="container">
    <label><b>enter amount you want people who poor financially</b></label>
      <input type="text"  name="am" >
    
      
      <button type="submit">enter</button>
      
    </div>

    
  </form>
</div>

<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>



</body>
</html>