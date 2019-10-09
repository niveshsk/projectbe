package credit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import bcard.Bankval;

/**
 * Servlet implementation class Agentreg
 */
@WebServlet("/Agentreg")
public class Agentreg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name =request.getParameter("name40");
		String user=request.getParameter("user40");
		String pass=request.getParameter("pass40");
		String pass1=request.getParameter("pass41");
		
		String dob =request.getParameter("dob40");
		
		String bcard =request.getParameter("bcard40");

		
	 
		try {
	if(pass.equals(pass1)){
			Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agent_db","root","root");
		PreparedStatement ps=con.prepareStatement("insert into profile(name,dob,b_card_no,user_id,password) values(?,?,?,?,?)");
		ps.setString(4, user);
		ps.setString(5, pass);
		
		ps.setString(2, dob);
		ps.setString(1, name);
		
		
		
		ps.setString(3, bcard);
		ps.executeUpdate();
   RequestDispatcher rd=request.getRequestDispatcher("/index.html");
   rd.forward(request, response);}
	} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
