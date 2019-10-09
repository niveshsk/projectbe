package bank;

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
 * Servlet implementation class Bankup
 */
@WebServlet("/Bankup")
public class Bankup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String name =request.getParameter("name1");
			String dob =request.getParameter("dob1");
		
			
			String gen =request.getParameter("gender1");
			String addr=request.getParameter("addr1");
		    int bal=0;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_db","root","root");
			PreparedStatement ps=con.prepareStatement("insert into profile(name,dob,balance,address,gender) values(?,?,?,?,?)");
			
		    ps.setString(2, dob);
			ps.setString(1, name);
			
			
	   	    ps.setString(5, gen);
			ps.setString(4, addr);
			ps.setInt(3, bal);
		   ps.execute();
		   PreparedStatement ps1=con.prepareStatement("select * from profile where name=? and dob=? and address=?");
		   ps1.setString(1, name);
		   ps1.setString(2, dob);
		   ps1.setString(3,addr);
		   ResultSet rs=ps1.executeQuery();
		   rs.next();
			String accno145 =rs.getString("acc_no");
			out.println(accno145);
		    
				RequestDispatcher rd=request.getRequestDispatcher("/trans.jsp");
				rd.include(request, response);
				con.close();	
		    
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}}


