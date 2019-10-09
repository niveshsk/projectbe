package credit;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

public class Risky {
	

	public static void upda(String acc, String lno, String bcardno, String name) {
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/risky_db","root","root");
		PreparedStatement ps=con.prepareStatement("insert into profile values(?,?,?,?) ");
		
	    ps.setString(1, name);
		ps.setString(4, bcardno);
		 ps.setString(2, acc);
			ps.setString(3, lno);
		
ps.executeUpdate();	
}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
