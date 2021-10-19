package diduler.model.calendar;

import java.util.LinkedList;
import java.util.List;
public abstract class Calendar {
	private int year;
	private List<Holiday> holidayList;
	
	public Calendar()
	{
		this(java.util.Calendar.getInstance().get(java.util.Calendar.YEAR),new LinkedList<Holiday>());
	}
	public Calendar(int year, List<Holiday> holidayList)
	{
		this.year = year;
		this.holidayList = holidayList;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public List<Holiday> getHolidayList() {
		return holidayList;
	}
	public void setHolidayList(List<Holiday> holidayList) {
		this.holidayList = holidayList;
	}
	
}
