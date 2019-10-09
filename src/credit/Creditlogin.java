package credit;

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
 * Servlet implementation class Creditlogin
 */
@WebServlet("/Creditlogin")
public class Creditlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String user =request.getParameter("user8");
	
		String pass=request.getParameter("pass8");
		
		try{
			System.out.println(user);
			System.out.println(pass);

			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agent_db","root","root");
			PreparedStatement ps=con.prepareStatement("select * from profile where user_id=? and password=?");
			ps.setString(1, user);
			
	       ps.setString(2, pass);
	      ResultSet rs=ps.executeQuery();
			request.getSession().setAttribute("agentname",user);

	       if(rs.next()){
RequestDispatcher rd=request.getRequestDispatcher("/user_validate.html");	
rd.forward(request, response);
	       }
	       else{
	    	   out.println("wrong user");
	   		RequestDispatcher rd=request.getRequestDispatcher("/credit_agent.html");	
	   		rd.include(request, response);
	       }
		}
	catch(Exception e){
		out.println("Check your entry");
		RequestDispatcher rd=request.getRequestDispatcher("/credit_agent.html");	
		rd.forward(request, response);
		e.printStackTrace();
	}
	}

}
