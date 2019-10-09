package loan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class Loan
 */
@WebServlet("/Loan")
public class Loan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String nam =request.getParameter("name3");
		String dob =request.getParameter("dob2");
		
		String dam =request.getParameter("dueam2");
		String amo =request.getParameter("amount2");
		String due=request.getParameter("due2");
		String addr=request.getParameter("addr3");
		int amon=Integer.parseInt(amo);
		int dueamo=Integer.parseInt(dam);
		int d=amon/dueamo;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_db","root","root");
		PreparedStatement ps=con.prepareStatement("insert into profile(name,dob,address,loan_amount,pending_due) values(?,?,?,?,?)");
		
	    ps.setString(2, dob);
		ps.setString(1, nam);
		
		
   	    ps.setString(4, amo);
		ps.setString(3, addr);    
	    ps.setInt(5, d);
ps.executeUpdate();
PreparedStatement ps1=con.prepareStatement("select * from profile where name=? and dob=?");
ps1.setString(1, nam);
ps1.setString(2, dob);
ResultSet rs1=ps1.executeQuery();
	   rs1.next();
	   String lno=rs1.getString("loan_no");
		Due.duedata(lno,amo,dam,due);
		
	    RequestDispatcher rd=request.getRequestDispatcher("/admin.html");
		rd.forward(request, response);	
		} catch (Exception e) {
			out.println("WRONG ENTRY");
			RequestDispatcher rd=request.getRequestDispatcher("/loanupdate.html");
			rd.include(request, response);	
			e.printStackTrace();
		}
		
}
	}

