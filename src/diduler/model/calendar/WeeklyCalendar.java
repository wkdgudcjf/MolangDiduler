package diduler.model.calendar;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class WeeklyCalendar extends Calendar{
	private Date startDate;
	
	public WeeklyCalendar()
	{
		this(new Date(), new LinkedList<Holiday>());
	}
	public WeeklyCalendar(Date startDate, List<Holiday> holidayList)
	{
		super(startDate.getYear(), holidayList);
		this.startDate = startDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
}
