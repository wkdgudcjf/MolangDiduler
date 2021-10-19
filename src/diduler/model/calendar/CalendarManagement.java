package diduler.model.calendar;

import diduler.model.WatermarkInfo;
import diduler.model.CalendarSize;

public class CalendarManagement {
	private Calendar calendar;
	private WatermarkInfo watermarkInfo;
	private CalendarSize calendarSize;
	
	public CalendarManagement()
	{
		this(null, WatermarkInfo.STEP_0, CalendarSize.MEDIUM);
	}
	public CalendarManagement(Calendar calendar, WatermarkInfo watermarkInfo, CalendarSize calendarSize)
	{
		this.calendar = calendar;
		this.watermarkInfo = watermarkInfo;
		this.calendarSize = calendarSize;
	}
	public Calendar getCalendar() {
		return calendar;
	}
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	public WatermarkInfo getWatermarkInfo() {
		return watermarkInfo;
	}
	public void setWatermarkInfo(WatermarkInfo watermarkInfo) {
		this.watermarkInfo = watermarkInfo;
	}
	public CalendarSize getCalendarSize() {
		return calendarSize;
	}
	public void setCalendarSize(CalendarSize calendarSize) {
		this.calendarSize = calendarSize;
	}
	public void printCalendar()
	{
		/////////////		구현 필요
	}
}
