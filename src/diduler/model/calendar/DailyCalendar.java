package diduler.model.calendar;

import java.util.Date;

public class DailyCalendar extends Calendar{
	private Date date;
	private boolean isHoliday;
	
	public DailyCalendar()
	{
		this(new Date(), false);
	}
	public DailyCalendar(Date date, boolean isHoliday)
	{
		super();
		this.date = date;
		this.isHoliday = isHoliday;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isHoliday() {
		return isHoliday;
	}
	public void setHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}
	
}
