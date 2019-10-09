import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dgth {
	public static void main(String[] args){
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");

		Date date=new Date(System.currentTimeMillis());
		System.out.println(date);
	}

}
