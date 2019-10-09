package loan;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

public class Validateloan {
    

	public static boolean upd(String lno, String name, String dob) {
		try{
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_db","root","root");
			PreparedStatement ps1=con.prepareStatement("select * from profile where loan_no=? and name=? and dob=? ");
			ps1.setString(1, lno);
			ps1.setString(2, name);
			ps1.setString(3, dob);
			ResultSet rs1 =ps1.executeQuery();
			rs1.next();
			String pending = rs1.getString("pending_due");
			
			
			int pend=Integer.parseInt(pending);
			if(pend<3){
				return true;
				
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	return false;	
	}
}
