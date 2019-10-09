<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
 <html>
   <head>
   

<link href="/project/css/a.css" rel="stylesheet"type="text/css">
      <title>bcard data</title>
  	<link rel="icon" href="/project/card.png" type="image/png">
       </head>
   <body style="color:red;font-size:30px;">
   WELCOME MR./MRS. <%=request.getSession().getAttribute("bna").toString().toUpperCase() %>
   <% String need=request.getSession().getAttribute("need").toString();%>
    <%if(need.equals("bio")){ %>
    <div align="center" id="basic" style="display:block;">
     <h1>BASIC INFORMATION</h1>
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/b_card_db"
         user = "root"  password = "root"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
         SELECT * from profile where b_card_number=<%=request.getSession().getAttribute("bno").toString() %> ;
      </sql:query>

      <table width="50%" border = "12" style="padding:10px;border-style:groove;background-color:white;" >
      
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
                <td>B CARD NUMBER</td>
              <td><c:out value = "${row.b_card_number}"/></td></tr>
             <tr>       <td>NAME</td>
               <td><c:out value = "${row.name}"/></td>
          </tr><tr>   <td>ADDRESS</td>  <td><c:out value = "${row.address}"/></td>
           </tr><tr>    <td>GENDER</td> <td><c:out value = "${row.gender}"/></td>
             </tr><tr><td>DATE OF BIRTH</td>   <td><c:out value = "${row.dob}"/></td></tr>
<tr>       <td>MAIL</td>        <td><c:out value = "${row.mail}"/></td></tr>
             
             <tr>  <td>GOLD</td> <td><c:out value = "${row.gold}"/></td></tr>
            
         <tr>        <td>PROPERTY</td>  <td><c:out value = "${row.property}"/></td>
            </tr>
         </c:forEach>
      </table>
 <%} %>    
       <%if(need.equals("bank")){ %> <div align="center" id="bank" style="display:block;">
     <h1>BANK STATEMENT</h1>

      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/b_card_db"
         user = "root"  password = "root"/>
      <sql:query dataSource = "${snapshot}" var = "result">
         SELECT * from bank_acc where b_card_number=<%=request.getSession().getAttribute("bno").toString() %> ;
      </sql:query>

      <table border = "12" style="padding:10px;border-style:groove;background-color:white;">
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
             <td>ACCOUNT NUMBER</td>  <td><c:out value = "${row.acc_no}"/></td></tr>
<tr>           <td>NAME</td>    <td><c:out value = "${row.name}"/></td></tr>
<tr>             <td>BALANCE</td>   <td><c:out value = "${row.balance}"/></td>
              
            </tr>
         </c:forEach>
      </table>
 </div>    
 <%} %>
         <%if(need.equals("loan")){ %>    
<div align="center" id="loan" style="display:block;">
     <h1>LOAN STATEMENT</h1>

      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/b_card_db"
         user = "root"  password = "root"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
         SELECT * from loan_acc where b_card_number=<%=request.getSession().getAttribute("bno").toString() %> ;
      </sql:query>

      <table border = "1" style="padding:10px;border-style:groove;background-color:white;">
       <tr>
       </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
                 <td>LOAN NUMBER</td>
               <td><c:out value = "${row.loan_no}"/></td></tr>
<tr>                    <td>NAME</td>
               <td><c:out value = "${row.name}"/></td></tr>
<tr>                  <td>PENDING DUE</td>
               <td><c:out value = "${row.pending_due}"/></td>
              
            </tr>
         </c:forEach>
      </table>
 </div>
 <%} %>
 <%if(need.equals("gold")){ %>
<div align="center" id="gold" style="display:block;"><br>
          <h1>GOLD INFORMATION</h1>
     
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/b_card_db"
         user = "root"  password = "root"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
         SELECT * from gold where b_card_number=<%=request.getSession().getAttribute("bno").toString() %> ;
      </sql:query>

      <table border = "12" style="padding:10px;border-style:groove;background-color:white;">
       
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
        <td>JEWELS</td>        <td><c:out value = "${row.jewels}"/> grams</td></tr>
     <tr>     <td>GOLDBARS</td>     <td><c:out value = "${row.goldbars}"/> grams</td></tr>
         <tr>   <td>GADGETS</td>   <td><c:out value = "${row.gadgets}"/></td></tr>
              
           
         </c:forEach>
      </table>
 </div>
<%} %>
   <%if(need.equals("property")) {%>
         <div align="center" id="pro" style="display:block;"><br>
      
           <h1>PROPERTY INFORMATION</h1>
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/b_card_db"
         user = "root"  password = "root"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
         SELECT * from property where b_card_number=<%=request.getSession().getAttribute("bno").toString() %> ;
      </sql:query>

      <table border = "12" style="padding:10px;border-style:groove;background-color:white;">
       
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
        <td>LAND 1</td>        <td><c:out value = "${row.land1}"/> sq.ft</td></tr>
     <tr>     <td>LAND 1 ADDRESS</td>     <td><c:out value = "${row.laadd1}"/></td></tr>
         <tr>   <td>LAND 2</td>   <td><c:out value = "${row.land2}"/> sq.ft</td></tr>
              
           <tr>
        <td>LAND 2 ADDRESS</td>        <td><c:out value = "${row.laaddr2}"/></td></tr>
     <tr>     <td>LAND 3</td>     <td><c:out value = "${row.land3}"/> sq.ft</td></tr>
         <tr>   <td>LAND 3 ADDRESS</td>   <td><c:out value = "${row.laadd3}"/></td></tr>
              <tr>
        <td>FLAT 1 ADDRESS</td>        <td><c:out value = "${row.fladd1}"/></td></tr>
     <tr>     <td>FLAT 2 ADDRESS</td>     <td><c:out value = "${row.fladd2}"/></td></tr>
         <tr>   <td>FLAT 3 ADDRESS</td>   <td><c:out value = "${row.fladd3}"/></td></tr>
              <tr>
        <td>SHOP 1 ADDRESS</td>        <td><c:out value = "${row.shadd1}"/></td></tr>
     <tr>     <td>SHOP 2 ADDRESS</td>     <td><c:out value = "${row.shadd2}"/></td></tr>
         <tr>   <td>SHOP 3 ADDRESS</td>   <td><c:out value = "${row.shadd3}"/></td></tr>
              
         </c:forEach>
      </table>
 </div>
     <%} %>
   <%if(need.equals("medical")) {%>
         <div align="center" id="pro" style="display:block;"><br>
      
           <h1>MEDICAL INFORMATION</h1>
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/b_card_db"
         user = "root"  password = "root"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
         SELECT * from blood where b_card_number=<%=request.getSession().getAttribute("bno").toString() %> ;
      </sql:query>

      <table border = "12" style="padding:10px;border-style:groove;background-color:white;">
       
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
        <td>HEART BEAT</td>        <td><c:out value = "${row.hbeat}"/> </td></tr>
     <tr>     <td>HEIGHT</td>     <td><c:out value = "${row.height}"/></td></tr>
         <tr>   <td>WEIGHT</td>   <td><c:out value = "${row.weight}"/></td></tr>
              
           <tr>
        <td>BLOOD PRESSURE</td>        <td><c:out value = "${row.blpre}"/></td></tr>
     <tr>     <td>BMI</td>     <td><c:out value = "${row.bmi}"/> </td></tr>
         <tr>   <td>HEART DESEASES</td>   <td><c:out value = "${row.hdise}"/></td></tr>
              <tr>
        <td>HEART DESEAES DETAIL</td>        <td><c:out value = "${row.hre}"/></td></tr>
     <tr>     <td>KIDNEY DESEAES</td>     <td><c:out value = "${row.kdise}"/></td></tr>
         <tr>   <td>KIDNEY DESEAES DETAILS</td>   <td><c:out value = "${row.kre}"/></td></tr>
              <tr>
        <td>BRAIN DESEASES</td>        <td><c:out value = "${row.brdise}"/></td></tr>
     <tr>     <td>BRAIN DESEASES DETAILS</td>     <td><c:out value = "${row.brre}"/></td></tr>
         <tr>   <td>BLOOD DESEASES</td>   <td><c:out value = "${row.bldise}"/></td></tr>
         <tr>   <td>BLOOD DESEASES DETAILS</td>   <td><c:out value = "${row.blre}"/></td></tr>
         <tr>   <td>SKIN DESEASES</td>   <td><c:out value = "${row.skdise}"/></td></tr>
          <tr>   <td>SKIN DESEASES DETAILS</td>   <td><c:out value = "${row.skre}"/></td></tr>
          <tr>   <td>STOMACH DESEASES</td>   <td><c:out value = "${row.stdise}"/></td></tr>
         <tr>   <td>STOMACH DESEASES DETAILS</td>   <td><c:out value = "${row.stre}"/></td></tr>
            
         </c:forEach>
      </table>
 </div>
     <%} %>
       <%if(need.equals("relation")) {%>
         <div align="center" id="pro" style="display:block;"><br>
      
           <h1>RELATION INFORMATION</h1>
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/b_card_db"
         user = "root"  password = "root"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
         SELECT * from relation where b_card_number=<%=request.getSession().getAttribute("bno").toString() %> ;
      </sql:query>
<table border = "12" style="padding:10px;border-style:groove;background-color:white;">
       
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
        <td>FATHER'S NAME</td>        <td><c:out value = "${row.fana}"/> </td></tr>
     <tr>     <td>FATHER'S AGE</td>     <td><c:out value = "${row.faage}"/></td></tr>
         <tr>   <td>MOTHER'S NAME</td>   <td><c:out value = "${row.mona}"/></td></tr>
              
           <tr>
        <td>MOTHER'S AGE</td>        <td><c:out value = "${row.moage}"/></td></tr>
     <tr>     <td>BROTHER'S NAME 1</td>     <td><c:out value = "${row.brna1}"/> </td></tr>
         <tr>   <td>BROTHER'S AGE 1</td>   <td><c:out value = "${row.brage1}"/></td></tr>
              <tr>
        <td>BROTHER'S NAME 2</td>        <td><c:out value = "${row.brna2}"/></td></tr>
     <tr>     <td>BROTHER'S AGE 2</td>     <td><c:out value = "${row.brage2}"/></td></tr>
         <tr>   <td>BROTHER'S NAME 3</td>   <td><c:out value = "${row.brna3}"/></td></tr>
              <tr>
        <td>BROTHER'S AGE 3</td>        <td><c:out value = "${row.brage3}"/></td></tr>
     <tr>     <td>SISTER'S NAME 1</td>     <td><c:out value = "${row.sina1}"/></td></tr>
         <tr>   <td>SISTER'S AGE 1</td>   <td><c:out value = "${row.siage1}"/></td></tr>
         <tr>   <td>SISTER'S NAME 2</td>   <td><c:out value = "${row.sina2}"/></td></tr>
         <tr>   <td>SISTER'S AGE 2</td>   <td><c:out value = "${row.siage2}"/></td></tr>
          <tr>   <td>SISTER'S NAME 3</td>   <td><c:out value = "${row.sina3}"/></td></tr>
          <tr>   <td>SISTER'S AGE 3</td>   <td><c:out value = "${row.siage3}"/></td></tr>
         
         </c:forEach>
      </table>
 </div>
     <%} %>
 </div><br><br>
 

   </body>
</html>