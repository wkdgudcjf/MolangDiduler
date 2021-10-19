package diduler.model.schedule;
import java.io.Serializable;
import java.util.*;

import diduler.model.diduler.DidulerList;

public class ScheduleList  extends DidulerList implements Serializable{
	private List<Schedule> scheduleList;
	
	public ScheduleList()
	{
		super();
		scheduleList = new LinkedList<Schedule>();
	}
	public ScheduleList(List<Schedule> scheduleList)
	{
		super();
		this.scheduleList = scheduleList;
		
		for(int i=0; i<scheduleList.size(); i++)
			super.add(scheduleList.get(i));
	}	
	public void add(Schedule schedule)
	{
		super.add(schedule);
		scheduleList.add(schedule);
	}
	public void add(String title, String content, boolean priority, boolean isPublic, Alarm alarm, Date startDate, Date endDate)
	{
		super.add(new Schedule(title, content, priority, isPublic, startDate, endDate, alarm));
		scheduleList.add(new Schedule(title, content, priority, isPublic, startDate, endDate, alarm));
	}
	public boolean remove(int sel)
	{		
		scheduleList.remove(sel);
		return super.remove(sel);
	}
	public boolean remove(Schedule schedule)
	{
		scheduleList.remove(schedule);
		return super.remove(schedule);
	}
	public String toString() {
		return "ScheduleList [scheduleList=" + super.getDidulerList() + "]";
	}
}
