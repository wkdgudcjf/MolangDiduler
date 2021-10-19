package diduler.mainUI;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Date writtenDate = new Date(Calendar.getInstance().get(Calendar.YEAR)-1900, Calendar.getInstance().
				 get(Calendar.MONTH),Calendar.getInstance().get(Calendar.DATE),Calendar.getInstance().get(Calendar.HOUR_OF_DAY ),
				 Calendar.getInstance().get(Calendar.MINUTE),Calendar.getInstance().get(Calendar.SECOND) );
		 
		

		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		  String now = df.format(writtenDate); 
		      
		 System.out.println(now); 
		 System.out.println(writtenDate.getTime());

		 System.out.println(writtenDate);
	}

}
