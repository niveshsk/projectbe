package bcard;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class Bcardlogin
 */
@WebServlet("/Bcardlogin")
public class Bcardlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String user =request.getParameter("name96");
		String bcard=request.getParameter("bcard");
		String pass=request.getParameter("pass96");
		String need=request.getParameter("need");
		request.getSession().setAttribute("bno", bcard);
		request.getSession().setAttribute("bpass", pass);
		request.getSession().setAttribute("bna", user);
        request.getSession().setAttribute("need", need);
		try{
			Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/b_card_db","root","root");
		PreparedStatement ps=con.prepareStatement("select * from profile where b_card_number=? and username=? and paasword=?");
		ps.setString(2, user);
		ps.setString(1, bcard);
       ps.setString(3, pass);
       ResultSet rs=ps.executeQuery();
       if(rs.next()){
       RequestDispatcher rd=request.getRequestDispatcher("/New.jsp");	
		rd.forward(request, response);
     /*  if(rs.next()){
       rs.next();
       
       String name=rs.getString("name");
       String acc=rs.getString("acc_no");
       String lno=rs.getString("loan_no");
       String addr=rs.getString("address");
       String dob=rs.getString("dob");
       String gen=rs.getString("gender");
       String mail=rs.getString("mail");
       String acc1=rs.getString("acc_no1");
       String bca=rs.getString("b_card_number");
       String pro=rs.getString("property");
       String go=rs.getString("gold");
       
       PreparedStatement ps1=con.prepareStatement("select * from bank_acc where acc_no=?");
       ps1.setString(1,acc);
       ResultSet rs1=ps1.executeQuery();
       rs1.next();
       String balance=rs1.getString("balance");
       
    	   out.println("<link href='/project/css/a.css' rel='stylesheet' type='text/css'>");
    	   out.println("<script>background-color: #fefefe;border: 1px solid #888;top:70%;width: 100%; bottom:70px;</script>");
    	   out.println("<div class='hh' align='center'>");
    	   out.println("<u>BANK DETAILS</u>");
    	   out.println("<table border='1'><tr><td>NAME:</td><td><b>"+name.toUpperCase()+"</b></td></tr><tr><td>GENDER:</td><td><b>"+gen +"</b></td></tr>");
    	   out.println("<tr><td>DATE OF BIRTH:</td><td><b>"+dob+"</b></td></tr><tr><td>MAIL ID:</td><td><b>"+mail.toUpperCase() +"</b></td></tr>");
    	   out.println("<tr><td>ADDRESS:</td><td><b>"+addr.toUpperCase()+"</b></td></tr><tr><td>Card Number:</td><td><b>"+bca +"</b></td></tr>");
    	   out.println("<tr><td>Bank Account Number:</td><td><b>"+acc+"</b></td></tr><tr><td>Bank Balance:</td><td><b>"+balance +"</b></td></tr>");
    	   if(!lno.equals("null")){
    	       PreparedStatement ps2=con.prepareStatement("select * from loan_acc where loan_no=?");
    	       ps2.setString(1, lno);
    	       ResultSet rs2=ps2.executeQuery();
    	       rs2.next();
    	       
    	       String pend=rs2.getString("pending_due");
	     	   out.println("<tr><td>Loan Number:</td><td><b>"+lno+"</b></td></tr><tr><td>Pending Due:</td><td><b>"+pend +"</b></td></tr>");

    	       }
    	   
    	   if(!acc1.equals("null")){
        	   
        	   PreparedStatement ps4=con.prepareStatement("select * from bank_acc where acc_no=?");
               ps4.setString(1,acc1);
               ResultSet rs4=ps1.executeQuery();
               rs4.next();
               String balance1=rs4.getString("balance");
               out.println("<tr><td>Bank account number 2:</td><td><b>"+acc1+"</b></td></tr><tr><td>Balance:</td><td><b>"+balance1 +"</b></td></tr>");
   
           }
         	   request.getSession().setAttribute("dno", bca);
    	   request.getSession().setAttribute("dname", name);
    	   out.println("</table>");
if(go.equals("yes")){
        	   
        	   PreparedStatement ps5=con.prepareStatement("select * from gold where b_card_number=?");
               ps5.setString(1,bcard);
               ResultSet rs5=ps5.executeQuery();
               rs5.next();
               out.println("<u>GOLD REPORT</u>");
               if(!(rs5.getInt("jewels")==0)){
               out.println("<table border='1'><tr><td>JEWELS:</td><td><b>"+rs5.getInt("jewels")+"grams</b></td></tr>");
               }
               if(!(rs5.getInt("goldbars")==0)){		
               out.println( "<tr><td>GOLDBARS:</td><td><b>"+rs5.getInt("goldbars") +"grams</b></td></tr>");
               }
               if(!rs5.getString("gadgets").equals("null")){
               out.println( "<tr><td>GADGETS:</td><td><b>"+rs5.getString("gadgets").toUpperCase()+"</b></td></tr></table>");
               }
           }
if(pro.equals("yes")){
	   
	   PreparedStatement ps6=con.prepareStatement("select * from property where b_card_number=?");
    ps6.setString(1,bcard);
    ResultSet rs6=ps6.executeQuery();
    rs6.next();
    String lan1=rs6.getString("land1");
    String lan2=rs6.getString("land2");
    String lan3=rs6.getString("land3");
    String ladd1=rs6.getString("laadd1");
    String ladd2=rs6.getString("laadd2");
    String ladd3=rs6.getString("laadd3");
    String fadd1=rs6.getString("fladd1");
    String fadd2=rs6.getString("fladd2");
    String fadd3=rs6.getString("fladd3");
    String sadd1=rs6.getString("shadd1");
    String sadd2=rs6.getString("shadd2");
    String sadd3=rs6.getString("shadd3");
    out.println("<u>PROPERTIES</u>");
    out.println("<table border='1'><tr><td>LAND 1:</td><td><b>"+lan1+"   square feets</b></td><td>"+ ladd1.toUpperCase()+"</td></tr>");
    if(!lan2.equals("null") && !ladd2.equals("null")){		
    out.println("<tr><td>LAND 2:</td><td><b>"+ lan2 +"  square feets</b></td><td>"+ ladd2.toUpperCase()+"</td></tr>");
    }
    if(!lan3.equals("null") && !ladd3.equals("null")){
    out.println("<tr><td>LAND 3:</td><td><b>"+lan3+"   square feets</b></td><td>"+ ladd3.toUpperCase()+"</td></tr>");
    }
    if(!fadd1.equals("null")){
        out.println("<tr><td>FLAT 1:</td><td></td><td>"+ fadd1.toUpperCase()+"</td></tr>");
        }
    if(!fadd2.equals("null")){
        out.println("<tr><td>FLAT 2:</td><td></td><td>"+ fadd2.toUpperCase()+"</td></tr>");
        }
    if(!fadd3.equals("null")){
        out.println("<tr><td>FLAT 3:</td><td></td><td>"+ fadd3.toUpperCase()+"</td></tr>");
        }
    if(!sadd1.equals("null")){
        out.println("<tr><td>SHOP 1:</td><td></td><td>"+ sadd1.toUpperCase()+"</td></tr>");
        }
    if(!sadd2.equals("null")){
        out.println("<tr><td>SHOP 2:</td><td></td><td>"+ sadd2.toUpperCase()+"</td></tr>");
        }
    if(!sadd3.equals("null")){
            out.println("<tr><td>SHOP 3:</td><td></td><td>"+ sadd3.toUpperCase()+"</td></tr>");
            }
    out.println("</table></div>");
}      
       }
       else
       {
    	   out.println("wrong user");
       }*/
       }
       else{
    	   out.println("account not exist");
       }}
	catch(Exception e){
		
		 RequestDispatcher rd=request.getRequestDispatcher("/New.jsp");	
			rd.forward(request, response);
		e.printStackTrace();
		
	}
	
	}

}
