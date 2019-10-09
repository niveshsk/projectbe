

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
 * Servlet implementation class Poor
 */
@WebServlet("/Poor")
public class Poor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String am=request.getParameter("am");
        int amo=Integer.parseInt(am);
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/b_card_db","root","root");
		PreparedStatement ps1=con.prepareStatement("select * from bank_acc where balance <= ? ");
        ps1.setInt(1, amo);
       ResultSet rs=ps1.executeQuery();
       out.println("<table style='border:20px'><tr><th>NAME</th><th>ACCOUNT NUMBER</th><th>BALANCE</th></tr>");
       while(rs.next()){
    	   out.println("<tr><td>"+rs.getString("name")+"</td><td>"+rs.getString("acc_no")+"</td><td>"+rs.getString("balance")+"</td></tr>");
       }
       out.println("</table>");
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}

}
