package bcard;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

public class Bankval {
  public static void validate(String lno,String acc,String acc1,String name,String bc){
	  try{
	  Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_db","root","root");
		PreparedStatement ps3=con.prepareStatement("select * from profile where acc_no=? and name=?");
	   ps3.setString(1, acc);
	   ps3.setString(2, name);
	   ResultSet rs=ps3.executeQuery();
	   
	   rs.next();
	  String bal= rs.getString("balance");
	  Bcardupdate.update(acc, name, bal,bc);
	 if(!lno.equals("null")){ 
	  Connection con1=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_db","root","root");
		PreparedStatement ps2=con1.prepareStatement("select * from profile where loan_no=? and name=?");
	   ps2.setString(1, lno);
	   ps2.setString(2, name);
	   ResultSet rs1=ps2.executeQuery();
	  
	   rs1.next();
	   String pend=rs1.getString("pending_due");
	   
	
	   Bcardupdate.loanupdate(lno,name,pend,bc);
	 }
	   if(!acc1.equals("null")){
		   PreparedStatement ps=con.prepareStatement("select * from profile where acc_no=? and name=?");
		   ps.setString(1, acc1);
		   ps.setString(2, name);
		   ResultSet rs2=ps.executeQuery();
		  rs2.next();
		   String bal1= rs2.getString("balance");
		  Bcardupdate.update(acc1, name, bal1,bc);
	   }
	  }
	  catch(Exception e){
		  
	  }
	  
  }
}
