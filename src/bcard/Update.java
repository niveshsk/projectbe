package bcard;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

public class Update {
	public static int update(String acc,int mone){
		 try{
			 
		 Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/b_card_db","root","root");
			PreparedStatement ps=con.prepareStatement("select * from bank_acc where acc_no=?");
			ps.setString(1, acc);
			boolean s=ps.execute();
			if(s){
				PreparedStatement ps2=con.prepareStatement("update bank_acc set balance=? where acc_no=?");
				ps2.setString(2, acc);
				ps2.setInt(1, mone);
				ps2.executeUpdate();
			}
	       
		 }
		 catch(Exception e){
			 e.printStackTrace();
			 
		 }
		return 0;

	 }
	 public static int loanupdate(String lno,String pend){
		 try{
			
		 Class.forName("com.mysql.jdbc.Driver");
			Connection con1=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/b_card_db","root","root");
			PreparedStatement ps1=con1.prepareStatement("select * from loan_acc where loan_no=?");
			ps1.setString(1, lno);
			
	    
	    boolean ls=ps1.execute();
	    if(ls){
	    	PreparedStatement ps3=con1.prepareStatement("update loan_acc set pending_due=? where loan_no=?");
			ps3.setString(2, lno);
			ps3.setString(1, pend);
			ps3.executeUpdate();
	    }
	    
		 }
		 catch(Exception e){
	          e.printStackTrace();		 
		 }
		 return 0;
		 }

}
