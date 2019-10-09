package bcard;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class Relation
 */
@WebServlet("/Relation")
public class Relation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String bcard =request.getParameter("bcardre");
        String user=request.getParameter("namere");
		String pass=request.getParameter("passre");
		String fana=request.getParameter("fana");
		String faage=request.getParameter("faage");
		
		String mona=request.getParameter("mona");
		String moage =request.getParameter("moage");

		String brna1=request.getParameter("brna1");
      	String brage1=request.getParameter("brage1");
      	String brna2=request.getParameter("brna2");
      	String brage2=request.getParameter("brage2");
      	String brna3=request.getParameter("brna3");
      	String brage3=request.getParameter("brage3");
      	String sina1=request.getParameter("sina1");
      	String siage1=request.getParameter("siage1");
      	String sina2=request.getParameter("sina2");
      	String siage2=request.getParameter("siage2");
      	String sina3=request.getParameter("sina3");
      	String siage3=request.getParameter("siage3");
      	try{
      		Class.forName("com.mysql.jdbc.Driver");
    		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/b_card_db","root","root");
    	          	PreparedStatement ps=con.prepareStatement("select * from profile where username =? and paasword=? and b_card_number=?");
    	          	ps.setString(1, user);
    	          	ps.setString(2, pass);
    	          	ps.setString(3, bcard);
    	          	ResultSet rs=ps.executeQuery();
    	          	if(rs.next()){
    	          		PreparedStatement ps1=con.prepareStatement("select * from relation where b_card_number=?");
    		          	
    		          	ps1.setString(1, bcard);
    		          	ResultSet rs1=ps1.executeQuery();	
    	          		if(!rs1.next()){
    	          		    PreparedStatement ps2=con.prepareStatement("insert into relation(b_card_number) values (?)");
    	          		    ps2.setString(1,bcard);
    	          		    ps2.execute();
    	          		}
    	          		String sw="yes";
    	          		String sw1="no";
    	          		 PreparedStatement ps3=con.prepareStatement("update profile set relation=? where username =? and paasword=? and b_card_number=?");
 		          		ps3.setString(2, user);
 			          	ps3.setString(3, pass);
 			          	ps3.setString(4, bcard);
 	          	        ps3.setString(1,sw);
 	          	        ps3.executeUpdate();
   	          		 PreparedStatement ps4=con.prepareStatement("update relation set fana=?, faage=?,mona=?,moage=?,brna1=?,brage1=?,brna2=?,brage2=?,brna3=?,brage3=?,sina1=?,siage1=?,sina2=?,siage2=?,sina3=?,siage3=? where b_card_number=?");
                     ps4.setString(1, fana);
                     ps4.setString(2, faage);
                     ps4.setString(3, mona);
                     ps4.setString(4, moage);
                     ps4.setString(5, brna1);
                     ps4.setString(6, brage1);
                     ps4.setString(7, brna2);
                     ps4.setString(8, brage2);
                     ps4.setString(9, brna3);
                     ps4.setString(10, brage3);
                     ps4.setString(11, sina1);
                     ps4.setString(12, siage1);
                     ps4.setString(13, sina2);
                     ps4.setString(14, siage2);
                     ps4.setString(15, sina3);
                     ps4.setString(16, siage3);
                   
                     ps4.setString(17, bcard);
                     ps4.executeUpdate();
        	         out.println("relation details upload succssfully<a href='/project/bcardlogin.html'>click here to login</a>");

    	          	}
    	          	}
	catch(Exception e){
		e.printStackTrace();
	}

	
	}

}
