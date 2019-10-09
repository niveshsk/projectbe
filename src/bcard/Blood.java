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
 * Servlet implementation class Blood
 */
@WebServlet("/Blood")
public class Blood extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String bcard =request.getParameter("bcardm");
        String user=request.getParameter("namem");
		String pass=request.getParameter("passm");
		String height=request.getParameter("hem");
		String weight=request.getParameter("wem");
		float hei=Float.parseFloat(height)/100;
		float wei=Float.parseFloat(weight);
		float bmi= wei/(hei*hei);
		
		String bp=request.getParameter("bpm");
		String hb =request.getParameter("hbm");

		String hdis=request.getParameter("hdis");
      	String hre=request.getParameter("hre");
      	String kdis=request.getParameter("kdis");
      	String kre=request.getParameter("kre");
      	String bdis=request.getParameter("bdis");
      	String bre=request.getParameter("bre");
      	String bldis=request.getParameter("bldis");
      	String blre=request.getParameter("blre");
      	String sdis=request.getParameter("sdis");
      	String sre=request.getParameter("sre");
      	String stdis=request.getParameter("stdis");
      	String stre=request.getParameter("stre");
      	try{
      		Class.forName("com.mysql.jdbc.Driver");
    		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/b_card_db","root","root");
    	          	PreparedStatement ps=con.prepareStatement("select * from profile where username =? and paasword=? and b_card_number=?");
    	          	ps.setString(1, user);
    	          	ps.setString(2, pass);
    	          	ps.setString(3, bcard);
    	          	ResultSet rs=ps.executeQuery();
    	          	if(rs.next()){
    	          		PreparedStatement ps1=con.prepareStatement("select * from blood where b_card_number=?");
    		          	
    		          	ps1.setString(1, bcard);
    		          	ResultSet rs1=ps1.executeQuery();	
    	          		if(!rs1.next()){
    	          		    PreparedStatement ps2=con.prepareStatement("insert into blood(b_card_number) values (?)");
    	          		    ps2.setString(1,bcard);
    	          		    ps2.execute();
    	          		}
    	          		String sw="yes";
    	          		String sw1="no";
    	          		 PreparedStatement ps3=con.prepareStatement("update profile set medical=? where username =? and paasword=? and b_card_number=?");
 		          		ps3.setString(2, user);
 			          	ps3.setString(3, pass);
 			          	ps3.setString(4, bcard);
 	          	        ps3.setString(1,sw);
 	          	        ps3.executeUpdate();
   	          		 PreparedStatement ps4=con.prepareStatement("update blood set hbeat=?, blpre=?,height=?,weight=?,bmi=?,hdise=?,hre=?,kdise=?,kre=?,brdise=?,brre=?,bldise=?,blre=?,skdise=?,skre=?,stdise=?,stre=? where b_card_number=?");
                     ps4.setString(1, hb);
                     ps4.setString(2, bp);
                     ps4.setString(3, height);
                     ps4.setString(4, weight);
                     ps4.setFloat(5, bmi);
                     ps4.setString(6, hdis);
                     ps4.setString(7, hre);
                     ps4.setString(8, kdis);
                     ps4.setString(9, kre);
                     ps4.setString(10, bdis);
                     ps4.setString(11, bre);
                     ps4.setString(12, bldis);
                     ps4.setString(13, blre);
                     ps4.setString(14, sdis);
                     ps4.setString(15, sre);
                     ps4.setString(16, stdis);
                     ps4.setString(17, stre);
                     ps4.setString(18, bcard);
                     ps4.executeUpdate();
        	         out.println("medical details upload succssfully<a href='/project/bcardlogin.html'>click here to login</a>");

    	          	}
    	          	}
	catch(Exception e){
		e.printStackTrace();
	}
	}

}
