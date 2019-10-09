package credit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class Creditreg
 */
@WebServlet("/Creditreg")
public class Creditreg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name =(String) request.getSession().getAttribute("ccnam");
		
		String pass =request.getParameter("pass101");
		String pass1 =request.getParameter("pass102");
		
		String bcard =request.getParameter("bcard87");
		String user=request.getParameter("user101");
	    
		try {
			Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/b_card_db","root","root");
		PreparedStatement ps=con.prepareStatement("select * from profile where b_card_number=? and name=?  ");
		
	    ps.setString(2, name);
		ps.setString(1, bcard);
		
	ResultSet rs =ps.executeQuery();
	
	rs.next();
	if(pass1.equals(pass)){
    	
         String userdob=rs.getString("dob");
         String useradd=rs.getString("address");
 		String agent=(String) request.getSession().getAttribute("agentname");

         DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
         Calendar cal2=Calendar.getInstance();
         cal2.add(Calendar.MONTH, 1);
         String datepay=df.format(cal2.getTime());
         Calendar cal1=Calendar.getInstance();
         
         String createdate=df.format(cal1.getTime());
         Connection con1=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/credit_card_db","root","root");
 		PreparedStatement ps1=con1.prepareStatement("insert into profile(name,b_card_no,dob,user_id,password,address,date_to_pay,open,created_by) values(?,?,?,?,?,?,?,?,?)  ");
 	    ps1.setString(1, name);
 		ps1.setString(2, bcard);
 	    ps1.setString(3, userdob);
 	    ps1.setString(4, user);
 	    ps1.setString(5, pass);
 	    ps1.setString(6, useradd);
 	    ps1.setString(7, datepay);
 	    ps1.setString(8, createdate);

 	    ps1.setString(9, agent);

 	ps1.executeUpdate();
 	
 	
		PreparedStatement ps2=con1.prepareStatement("select *from profile where b_card_no=?");
	    
		ps2.setString(1, bcard);
		
	    ResultSet rs1=ps2.executeQuery();
	    rs1.next();
	    String cno=rs1.getString("c_card_no");
	    request.setAttribute("cno",cno);
	    request.setAttribute("nameofc",name);
	    request.setAttribute("ageofc",userdob);
	    request.setAttribute("useradd", useradd);
	    RequestDispatcher rd4=request.getRequestDispatcher("/report.jsp");
	    rd4.forward(request, response);
    }
	
		} catch (Exception e) {
			e.printStackTrace();
			out.println("already credit card user");
			RequestDispatcher rd4=request.getRequestDispatcher("/credit.jsp");
		    rd4.include(request, response);
		}
		
}
	}


