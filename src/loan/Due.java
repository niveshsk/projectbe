package loan;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;

import org.omg.CORBA.Request;

import com.mysql.jdbc.Connection;

public class Due {

	public static void duedata(String lno,String amo,String dam,String date){
	    
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_db","root","root");
			 
				int amon=Integer.parseInt(amo);
				int dueamo=Integer.parseInt(dam);
				int due=amon/dueamo;
				while(due!=0){
				DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				
				Calendar cal=Calendar.getInstance();
				cal.setTime(df.parse(date));
				cal.add(Calendar.MONTH,1);
				String dat=df.format(cal.getTime());
				PreparedStatement ps=con.prepareStatement("insert into due_data(loan_no,due_date,due_amount) values(?,?,?)");
			
		    ps.setFloat(3, dueamo);
			ps.setString(1, lno);
			ps.setString(2,dat );
			
			
	   	       
		     date=dat;
		   ps.executeUpdate();
		 due--;
				}}			
			
			
			catch (Exception e) {
				
				e.printStackTrace();
			}
			
	}
	}

