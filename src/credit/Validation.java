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
import bank.*;
import com.mysql.jdbc.Connection;
import loan.*;
/**
 * Servlet implementation class Validation
 */
@WebServlet("/Validation")
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String user =request.getParameter("user45");
		String bcardno=request.getParameter("bcard45");
		String pass=request.getParameter("pass45");
		String pin =request.getParameter("pin45");
		String dob=request.getParameter("dob45");
		String name=request.getParameter("name45");
		request.getSession().setAttribute("ccnam",name);
		

		try{
			
			if(pin.equals("9677690496")){
			Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/b_card_db","root","root");
		PreparedStatement ps=con.prepareStatement("select * from profile where b_card_number=? and username=? and paasword=?");
		ps.setString(2, user);
		ps.setString(1, bcardno);
       ps.setString(3, pass);
       ResultSet rs=ps.executeQuery();
       boolean aq=rs.next();
       String acc=rs.getString("acc_no");
       String lno=rs.getString("loan_no");
       String acc1=rs.getString("acc_no1");
     if(aq){
       
     
    
      boolean bankacc= Validate.upd(acc,name,dob);
        
     
      if(bankacc){
    	  if(lno.equals("null") && acc1.equals("null")){
    		
    	     	 out.println("THE USER ELIGIBLE FOR CREDIT CARD by bank account");
    	 		  RequestDispatcher rd=request.getRequestDispatcher("/credit.jsp");
    	 		  rd.forward(request, response);}   
    	  if(!lno.equals("null")){ 
    		   boolean loanacc=Validateloan.upd(lno,name,dob);
    	  if(loanacc){
    		  if(!acc1.equals("null"))	 {
    	    		boolean bankacc1=Validate.upd(acc1,name,dob);
    	    		if(bankacc1){
    	    			out.println("THE USER ELIGIBLE FOR CREDIT CARD");
    	    			RequestDispatcher rd=request.getRequestDispatcher("/credit.jsp");
    		    		  rd.forward(request, response);
    	    		}
    	    		else{
    	    			out.println("NOT ELIGIBLE based on second account");
    	    			out.println("NOT ELIGIBLE USER");
    	    		}
	    			
    	    		 
    	    	}
    		  else{
    			  out.println("THE USER ELIGIBLE FOR CREDIT CARD");
	    		  RequestDispatcher rd=request.getRequestDispatcher("/credit.jsp");
	    		  rd.forward(request, response);
    		  }
    		 
    	  }
    	  
    	else{
    		
    	 Risky.upda(acc,lno,bcardno,name);
    	 out.println("NOT ELIGIBLE based on loan account");
    	 out.println("NOT ELIGIBLE USER");
    	 RequestDispatcher rd  = request.getRequestDispatcher("/home.html");    	
    	 rd.include(request, response);
    	 }
    	}
    	
		  }
      
      else{
    	  out.println("NOT ELIGIBLE based on bank account");
     	 out.println("NOT ELIGIBLE USER");
      }
      
      }
    
     }
			 
       }
	catch(Exception e){
		out.println("wrong entry");
		RequestDispatcher rd4=request.getRequestDispatcher("/user_validate.html");
	    rd4.include(request, response);
		e.printStackTrace();
		
	}
	
		
	

}}
