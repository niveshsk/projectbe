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
 * Servlet implementation class Property
 */
@WebServlet("/Property")
public class Property extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String bcard =request.getParameter("bcardpr");
        String user=request.getParameter("namepr");
		String pass=request.getParameter("passpr");
		String sw="yes";
		String sw1="no";
		
		String la1=request.getParameter("land1");
      	String lad1=request.getParameter("ladd1");
      	String la2=request.getParameter("land2");
      	String lad2=request.getParameter("ladd2");
      	String la3=request.getParameter("land3");
      	String lad3=request.getParameter("ladd3");
      	String fad1=request.getParameter("fadd1");
      	String fad3=request.getParameter("fadd3");
      	String fad2=request.getParameter("fadd2");
      	String sad1=request.getParameter("sadd1");
      	String sad2=request.getParameter("sadd2");
      	String sad3=request.getParameter("sadd3");

		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/b_card_db","root","root");
	          	PreparedStatement ps=con.prepareStatement("select * from profile where username =? and paasword=? and b_card_number=?");
	          	ps.setString(1, user);
	          	ps.setString(2, pass);
	          	ps.setString(3, bcard);
	          	ResultSet rs=ps.executeQuery();
	          	if(rs.next()){
	          		PreparedStatement ps1=con.prepareStatement("select * from property where b_card_number=?");
		          	
		          	ps1.setString(1, bcard);
		          	ResultSet rs1=ps1.executeQuery();	
	          		if(!rs1.next()){
	          		    PreparedStatement ps2=con.prepareStatement("insert into property(b_card_number) values (?)");
	          		    ps2.setString(1,bcard);
	          		    ps2.execute();
	          		}
	          	
	          	if(!la1.equals("0") && !lad1.equals("nil")){
	          		 PreparedStatement ps3=con.prepareStatement("update property set land1=?,laadd1=? where b_card_number=?");
	          		    ps3.setString(3,bcard);
	          		    ps3.setString(1, la1);
	          		    ps3.setString(2, lad1);
	          		    ps3.executeUpdate();
		          		 PreparedStatement ps13=con.prepareStatement("update profile set property=? where username =? and paasword=? and b_card_number=?");
		          		ps13.setString(2, user);
			          	ps13.setString(3, pass);
			          	ps13.setString(4, bcard);
	          	        ps13.setString(1,sw);
	          	        ps13.executeUpdate();
	          	}
	          	
	          	if(!la2.equals("0") && !lad2.equals("nil")){
	          		 PreparedStatement ps4=con.prepareStatement("update property set land2=?,laadd2=? where b_card_number=?");
	          		    ps4.setString(3,bcard);
	          		    ps4.setString(1, la2);
	          		    ps4.setString(2, lad2);
	          		    ps4.executeUpdate();
	          	}
	          	if(!la3.equals("0") && !lad3.equals("nil")){
	          		 PreparedStatement ps5=con.prepareStatement("update property set land3=?,laadd3=? where b_card_number=?");
	          		    ps5.setString(3,bcard);
	          		    ps5.setString(1, la3);
	          		    ps5.setString(2, lad3);
	          		    ps5.executeUpdate();
	          	}
	          
	          	
	          	if(!fad1.equals("nil") ){
	          		 PreparedStatement ps6=con.prepareStatement("update property set fladd1=? where b_card_number=?");
	          		    ps6.setString(2,bcard);
	          		    ps6.setString(1, fad1);	          		   
	          		    ps6.executeUpdate();
	          	}
	          	if(!fad2.equals("nil") ){
	          		 PreparedStatement ps7=con.prepareStatement("update property set fladd2=? where b_card_number=?");
	          		    ps7.setString(2,bcard);
	          		    ps7.setString(1, fad2);	          		   
	          		    ps7.executeUpdate();
	          	}
	          	
	          	if(!fad3.equals("nil") ){
	          		 PreparedStatement ps8=con.prepareStatement("update property set fladd3=? where b_card_number=?");
	          		    ps8.setString(2,bcard);
	          		    ps8.setString(1, fad3);	          		   
	          		    ps8.executeUpdate();
	          	}
	          	if(!sad1.equals("nil") ){
	          		 PreparedStatement ps9=con.prepareStatement("update property set shadd1=? where b_card_number=?");
	          		    ps9.setString(2,bcard);
	          		    ps9.setString(1, sad1);	          		   
	          		    ps9.executeUpdate();
	          	}
	          	if(!sad2.equals("nil") ){
	          		 PreparedStatement ps10=con.prepareStatement("update property set shadd2=? where b_card_number=?");
	          		    ps10.setString(2,bcard);
	          		    ps10.setString(1, sad2);	          		   
	          		    ps10.executeUpdate();
	          	}
	          	if(!sad3.equals("nil") ){
	          		 PreparedStatement ps11=con.prepareStatement("update property set shadd3=? where b_card_number=?");
	          		    ps11.setString(2,bcard);
	          		    ps11.setString(1, sad3);	          		   
	          		    ps11.executeUpdate();
	          	}
	          	}
	          	
	          	else
	          	{
	          		out.println("account not exist");
	          	}
	          			
	          			
	        	if(la1.equals("0") && lad1.equals("nil") && la2.equals("0") && lad2.equals("nil") && la3.equals("0") && lad3.equals("nil")
	        			&&fad1.equals("nil")&&fad2.equals("nil")&&fad3.equals("nil")&&sad1.equals("nil")&&sad2.equals("nil")&&sad3.equals("nil")){
	        		PreparedStatement ps14=con.prepareStatement("update profile set property=? where username =? and paasword=? and b_card_number=?");
	          		ps14.setString(2, user);
		          	ps14.setString(3, pass);
		          	ps14.setString(4, bcard);
          	        ps14.setString(1,sw1);
          	        ps14.executeUpdate();
	        		
	        	}     			
	          			
	          			
	          			
	          			
	          			
	          			
	          			
	          			
	          			
	          			
	          			
	          			
	          			
	          			
	          			
	          			
	          			
	          	
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}

}
