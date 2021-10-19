package diduler.model.calendar;

import java.util.LinkedList;
import java.util.List;

public class MonthlyCalendar extends Calendar{

	private int month;
	
	public MonthlyCalendar()
	{
		this(java.util.Calendar.getInstance().get(java.util.Calendar.YEAR),
				java.util.Calendar.getInstance().get(java.util.Calendar.MONTH)
				,new LinkedList<Holiday>());
	}
	public MonthlyCalendar(int year, int month, List<Holiday> holidayList)
	{
		super(year, holidayList);
		this.month = month;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
}
