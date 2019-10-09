package bcard;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.Connection;
@MultipartConfig(maxFileSize = 655656565)
public class Bcardreg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name =request.getParameter("name");
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		String pass1=request.getParameter("pass1");
		String email=request.getParameter("mail");
		String dob =request.getParameter("dob");
		String acc =request.getParameter("accno");
		String acc1 =request.getParameter("accno8");

		String lno =request.getParameter("loanno");
		String gen =request.getParameter("gender");
		String addr=request.getParameter("addr");
	 
		try {
	
			Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/b_card_db","root","root");
		
		if(pass.equals(pass1)){
		PreparedStatement ps=con.prepareStatement("insert into profile(name,acc_no,loan_no,address,username,paasword,dob,gender,mail,acc_no1) values(?,?,?,?,?,?,?,?,?,?)");
		ps.setString(5, user);
		ps.setString(6, pass);
		ps.setString(9, email);
		ps.setString(7, dob);
		ps.setString(1, name);
		ps.setString(2, acc);
		ps.setString(3, lno);
		ps.setString(8, gen);
		ps.setString(4, addr);
		ps.setString(10, acc1);
		int rs=ps.executeUpdate();
		
	if(rs>0){
		
		PreparedStatement ps3=con.prepareStatement("select * from profile where name=? and username=? and paasword=?");
        ps3.setString(1, name);
        ps3.setString(2, user);
        ps3.setString(3, pass);


        ResultSet rs3=ps3.executeQuery();
        rs3.next();
       String ccno=rs3.getString("b_card_number");
       out.println(ccno);
       Bankval.validate(lno,acc,acc1,name,ccno);
		out.println("register completed <a href='/project/bcardlogin.html'> click here</a> to login");
		}
	else{
		out.println("already exists account<a href='/project/bcardreg.html'> click here</a> to back to registration");
		
	}
	}
	
	} catch (Exception e) {
		out.println("wrong entry");
		out.println("<a href='/project/bcardreg.html'> click here</a> to back to registration");

			e.printStackTrace();
		}}
	}


