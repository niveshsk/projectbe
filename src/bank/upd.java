package bank;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.mysql.jdbc.Connection;

import bcard.Update;

public class upd {
	public static void upda(String acc, String sat, String mo){
	
	{
	try{
	
		int amou=Integer.parseInt(mo);
	
	   Class.forName("com.mysql.jdbc.Driver");
			Connection con1=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_db","root","root");
			
		    PreparedStatement ps1=con1.prepareStatement("select * from profile where acc_no=?");
		    ps1.setString(1,acc);
	
		    ResultSet rs =ps1.executeQuery();
			  
            rs.next();
		    String mone=rs.getString("balance");
		    
		    
		    int mony =Integer.parseInt(mone);
		    PreparedStatement ps5=con1.prepareStatement("select acc_no from profile where acc_no=?");
		    ps5.setString(1,acc);
		
		    boolean bs =ps5.execute();
			
		    if(bs)
		    {
		    if(sat.equals("deposit")){
			  
			      mony=mony+amou;
				
				PreparedStatement ps3=con1.prepareStatement("update profile set balance= ? where acc_no=?");
				ps3.setInt(1, mony);
				ps3.setString(2, acc);	
	
				ps3.executeUpdate();
				
		    }
		    else{
		    	 mony=mony-amou;
					
					PreparedStatement ps3=con1.prepareStatement("update profile set balance= ? where acc_no=?");
					ps3.setInt(1, mony);
					ps3.setString(2, acc);	
		
					ps3.executeUpdate();
		    }
				
			}
  Update.update(acc,mony);
	
	}
	
	catch(Exception e){e.printStackTrace();}
	}}}
	



	