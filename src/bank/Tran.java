package bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bank.upd;
import com.mysql.jdbc.Connection;


/**
 * Servlet implementation class Tran
 */
@WebServlet("/Tran")
public class Tran extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String stat =request.getParameter("status");
		String dob =request.getParameter("dat");
		String acc =request.getParameter("accno2");
		String name=request.getParameter("name2");
		String mon =request.getParameter("money");
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_db","root","root");
		PreparedStatement ps1=con.prepareStatement("select * from profile where acc_no=? and name=?");
        ps1.setString(1, acc);
        ps1.setString(2, name);
        boolean s=ps1.execute();
        if(s){
		PreparedStatement ps=con.prepareStatement("insert into transaction (acc_no,status,date,money) values(?,?,?,?)");
		
	    ps.setString(3, dob);
		ps.setString(2,stat );
		ps.setString(1, acc);
		ps.setString(4, mon);
	    ps.executeUpdate();}
	    upd.upda(acc, stat, mon);
	    out.println("thank you for update<br>");
	

	   out.println(mon+"rupess    "+stat+"   in the account  "+acc+  "account holder name is "+name);
	    con.close();
	    
	    
	 	}
		catch(Exception e){
		
			e.printStackTrace();
			
			
		}
		
		}
		}


