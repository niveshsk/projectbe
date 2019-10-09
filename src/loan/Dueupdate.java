package loan;

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

import bcard.Update;

/**
 * Servlet implementation class Dueupdate
 */
@WebServlet("/Dueupdate")
public class Dueupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String lno =request.getParameter("loanno3");
		String due =request.getParameter("due3");
		String dueamo=request.getParameter("duea");
		String st="PAID";
		String st2="pending";
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_db","root","root");
		PreparedStatement ps5=con.prepareStatement("select * from due_data where loan_no=? ");
		ps5.setString(1, lno);
		ResultSet rs5 =ps5.executeQuery();
       
		PreparedStatement ps=con.prepareStatement("select * from due_data where loan_no=? and due_date=? and due_amount=?");
		PreparedStatement ps3=con.prepareStatement("select name from profile where loan_no=?");
        ps3.setString(1, lno);
        ResultSet rs3=ps3.executeQuery();
        rs3.next();
        ps.setString(1, lno);
		ps.setString(2, due);
		ps.setString(3,dueamo);
        

		ResultSet rs =ps.executeQuery();
		
		boolean e=rs.next();
		String st1=rs.getString("status");

	   if(e && !st1.equals(st) ){
			PreparedStatement ps1=con.prepareStatement("update due_data set status=? where loan_no=? and due_date=? and due_amount=?");
            ps1.setString(1, st);
            ps1.setString(2, lno);
            ps1.setString(3, due);
            ps1.setString(4, dueamo);
            ps1.execute();
            out.println("Due updated");
            RequestDispatcher rd=request.getRequestDispatcher("/admin.html");
    		rd.include(request, response);
	   }
	   else{
	   
	   String name=rs3.getString("name").toUpperCase();
	   out.println("<fieldset>");
	   out.println("WELCOME MR./MRS.<b>"+name+"</b><br><h2>DUE DATA</h2><br>"	);
	  out.println("<table><r><th>due_date</th><th>due_amount</th><th>status</th></tr>");
	  while(rs5.next()){
		  String a=rs5.getString("due_date");
		   String b=rs5.getString("due_amount");
		   String c=rs5.getString("status");
	  out.println("<tr><td>"+a+"</td><td>"+b+"</td><td>"+c+"</tr>");
	  
	   
	  }
	  out.println("</table></fieldset>");
	  RequestDispatcher rd1=request.getRequestDispatcher("/dueupdate.html");
		rd1.include(request, response);
	   }
	   PreparedStatement ps9=con.prepareStatement("select count(*) from due_data where loan_no=? and status=?");
       ps9.setString(1, lno);
       ps9.setString(2, st2);
       ResultSet rs9=ps9.executeQuery();
       rs9.next();
        String count=rs9.getString(1);
        PreparedStatement ps10=con.prepareStatement("update profile set pending_due=? where loan_no=?");
        ps10.setString(1, count);
        ps10.setString(2, lno);
        ps10.execute();
        Update.loanupdate(lno, count);
	
	}catch(Exception e){
		out.println("WRONG ENTRY");
		  RequestDispatcher rd2	=request.getRequestDispatcher("/dueupdate.html");
			rd2.include(request, response);
	e.printStackTrace();
	
	}
	}

}
