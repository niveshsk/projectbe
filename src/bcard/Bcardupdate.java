package bcard;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

public class Bcardupdate {
 public static int update(String acc,String name,String bal,String bc){
	 try{
		 
	 Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/b_card_db","root","root");
		PreparedStatement ps=con.prepareStatement("insert into bank_acc values(?,?,?,?)");
		ps.setString(2, acc);
		ps.setString(1, name);
       ps.setString(3, bal);
       ps.setString(4, bc);
       ps.executeUpdate();
       
	 }
	 catch(Exception e){
		 e.printStackTrace();
		 
	 }
	return 0;

 }
 public static int loanupdate(String lno,String name,String pend,String bc){
	 try{
		
	 Class.forName("com.mysql.jdbc.Driver");
		Connection con1=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/b_card_db","root","root");
		PreparedStatement ps1=con1.prepareStatement("insert into loan_acc values(?,?,?,?)");
		ps1.setString(2, lno);
		ps1.setString(1, name);
    ps1.setString(3, pend);
    ps1.setString(4, bc);
    ps1.executeUpdate();
    
	 }
	 catch(Exception e){
          e.printStackTrace();		 
	 }
	 return 0;
	 }
}
