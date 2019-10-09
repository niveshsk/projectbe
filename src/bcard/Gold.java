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
 * Servlet implementation class Gold
 */
@WebServlet("/Gold")
public class Gold extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String bcard =request.getParameter("bcardgo");
		String user=request.getParameter("namego");
		String pass=request.getParameter("passgo");
		String jewel=request.getParameter("goje");
		String goldbar=request.getParameter("goba");
		String gadget =request.getParameter("goga");
	  
	  String go="yes";
	  String gow="no"; 
		try {
	
			Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/b_card_db","root","root");
	          	PreparedStatement ps9=con.prepareStatement("select * from profile where username =? and paasword=? and b_card_number=?");
	          	ps9.setString(1, user);
	          	ps9.setString(2, pass);
	          	ps9.setString(3, bcard);
	          	ResultSet rs=ps9.executeQuery();
		if(rs.next()){
			
			PreparedStatement ps8=con.prepareStatement("insert into gold(b_card_number,jewels,goldbars,gadgets) values(?,?,?,?) ");
			ps8.setString(1, bcard);
			ps8.setString(2, jewel);
			ps8.setString(3, goldbar);
			ps8.setString(4, gadget);
			ps8.execute();
			ps8.close();
		if(!jewel.equals("null")||!goldbar.equals("null")||!gadget.equals("null")){
		PreparedStatement ps7=con.prepareStatement("update profile set gold=? where username =? and paasword=? and b_card_number=? ");
		

	    ps7.setString(1, go);
		ps7.setString(2, user);
		ps7.setString(3, pass);
		
		ps7.setString(4, bcard);
        ps7.execute();
		}
		if(jewel.equals("null")&&goldbar.equals("null")&&gadget.equals("null")){
			PreparedStatement ps6=con.prepareStatement("update profile set gold=? where username =? and paasword=? and b_card_number=? ");
			

		    ps6.setString(1, gow);
			ps6.setString(2, user);
			ps6.setString(3, pass);
			
			ps6.setString(4, bcard);
	        ps6.execute();	
		}
		}
		else{
			out.println("not exits account");
		}
	} catch (Exception e) {
		out.println("wrong entry");
		
			e.printStackTrace();
		}
	}

}
