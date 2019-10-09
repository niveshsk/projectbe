package bank;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import com.mysql.jdbc.Connection;

public class Validate {
	public static boolean upd(String acc,String name,String dob){
		try{
			

			   Class.forName("com.mysql.jdbc.Driver");
					Connection con1=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_db","root","root");
					String st ="deposit";
					int count=0;
					PreparedStatement ps=con1.prepareStatement("select * from profile where acc_no=? and name=? and dob=?");
					ps.setString(1, acc);
					ps.setString(2, name);
					ps.setString(3, dob);
					Boolean chk=ps.execute();
					
					if(chk){
				    PreparedStatement ps1=con1.prepareStatement("select * from transaction where acc_no=? and status=? ");
				    ps1.setString(1,acc);	
				    ps1.setString(2,st );
				    ResultSet rs =ps1.executeQuery();
				    
				    DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				    Calendar cal1=Calendar.getInstance();
				    cal1.add(Calendar.YEAR, -1);
				    cal1.getTime();
				         while(rs.next()){
				    String d = rs.getString("date");
				    int bal=rs.getInt("money");
				    
					Calendar cal=Calendar.getInstance();
					cal.setTime(df.parse(d));
					
					          if(cal.after(cal1)){
						count=count+bal;
					            }
				
				        }
				    if(count>=100000){
						System.out.println(count);

				    	return true;
				    }
				    else{
				    	return false;
				    }
				    }
					
					
					
					
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
		
		
	}

}
