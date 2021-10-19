package diduler.mainUI;

import java.util.Calendar;
import java.util.LinkedList;

public class CalendarController {
	public CalendarController() {	
	}
	public int getDateInDayUI(int year, int month)
	{
		Calendar temp = Calendar.getInstance();
		
		temp.set(Calendar.YEAR,year);
		temp.set(Calendar.MONTH, month-1);
		temp.set(Calendar.DATE, 1);
		
		return temp.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	public int getMaximumInWeekUI(int year, int month)
	{
		Calendar temp = Calendar.getInstance();	
		
		temp.set(Calendar.YEAR,year);
		temp.set(Calendar.MONTH, month-1);
		temp.set(Calendar.DATE, 1);
		
		return temp.getActualMaximum(Calendar.WEEK_OF_MONTH);
	}
	public LinkedList<String> getDateInWeekUI(int year, int month, int week)
	{
		LinkedList<String> list = new LinkedList<String>();
		
		Calendar temp = Calendar.getInstance();	
		
		temp.set(Calendar.YEAR,year);
		temp.set(Calendar.MONTH, month-1);
		temp.set(Calendar.WEEK_OF_MONTH, week);
		
		for(int i=0; i<7; i++)
		{
			temp.add(Calendar.DATE, 1+i - temp.get(Calendar.DAY_OF_WEEK));
			list.add(temp.get(Calendar.DAY_OF_MONTH)+"");	
		}
		return list;
	}
	public LinkedList<String> getDateInMonthUI(int year, int month)
	{
		LinkedList<String> list = new LinkedList<String>();
		Calendar temp = Calendar.getInstance();
		
		temp.set(Calendar.YEAR,year);
		temp.set(Calendar.MONTH, month-1);
		temp.set(Calendar.DATE, 1);
		for(int i=0; i<temp.get(Calendar.DAY_OF_WEEK)-1; i++)
			list.add("");
		
		int maxDate = temp.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		for(int i=1; i<=maxDate; i++)
		{
			list.add(i+"");
		}
		for(int i=list.size(); i<42; i++)
			list.add("");
		return list;
	}
	
	
}
