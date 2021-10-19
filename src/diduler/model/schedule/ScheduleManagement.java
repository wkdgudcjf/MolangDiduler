package diduler.model.schedule;

import java.util.*;
import diduler.model.diduler.*;
import diduler.model.SearchType;

public class ScheduleManagement extends DidulerManagement implements ScheduleAdd, ScheduleModify{
	private ScheduleList scheduleList;
	
	public ScheduleManagement() {
		this(new ScheduleList());
	}
	public ScheduleManagement(ScheduleList scheduleList) {
		super(scheduleList);
		this.scheduleList = scheduleList;
	}
	
	public void setScheduleList(ScheduleList scheduleList)
	{
		this.scheduleList = scheduleList;
		super.setDidulerList(scheduleList);
		
	}
	public ScheduleList getScheduleList()
	{
		return scheduleList;
	}
	public void add(Diduler diduler) 
	{
		scheduleList.add(diduler);
	}
	public void add(Schedule schedule)
	{
		scheduleList.add(schedule);
	}
	public void add(String title, String content)
	{
		Schedule schedule = new Schedule(title, content);
		scheduleList.add(schedule);
	}
	public void add(String title, String content, boolean isPublic)
	{
		Schedule schedule = new Schedule(title, content, isPublic);
		scheduleList.add(schedule);
	}
	public void add(String title, String content, boolean priority, boolean isPublic, Alarm alarm, Date startDate, Date endDate)
	{
		Schedule schedule = new Schedule(title, content, priority, isPublic, startDate, endDate, alarm);
		scheduleList.add(schedule);
	}
	public void add(String title, String content, Date startDate, Date endDate)
	{
		Schedule schedule = new Schedule(title, content, startDate, endDate);
		scheduleList.add(schedule);
	}
	public void add(String title, String content, boolean priority, Alarm alarm, Date startDate, Date endDate)
	{
		Schedule schedule =new Schedule(title, content, priority, startDate, endDate, alarm);
		scheduleList.add(schedule);
	}
	public void add(String title, String content, boolean priority, boolean isPublic, Date startDate, Date endDate)
	{
		Schedule schedule =new Schedule(title, content, priority, isPublic, startDate, endDate);
		scheduleList.add(schedule);
	}
	public boolean modify(Diduler oldDiduler, Diduler newDiduler)
	{		
		int index = super.getDidulerList().indexOf(oldDiduler);
		
		if(index == -1)
			return false;
		
		super.getDidulerList().set(index, newDiduler);
		
		index = scheduleList.indexOf(oldDiduler);
		if(index==-1)
			return false;
		
		scheduleList.set(index, newDiduler);
		return true;
	}
	public boolean modify(Schedule oldSchedule, Schedule newSchedule)
	{
		int index = super.getDidulerList().indexOf(oldSchedule);
		
		if(index == -1)
			return false;
		
		super.getDidulerList().set(index, newSchedule);
		
		index = scheduleList.indexOf(oldSchedule);
		if(index==-1)
			return false;
		
		scheduleList.set(index, newSchedule);
		return true;
	}	
	public boolean modify(Schedule schedule, ScheduleInfo field, String fieldContent)
	{
		int index = super.getDidulerList().getDidulerList().indexOf(schedule);
		if(index == -1)
			return false;
		if(field == ScheduleInfo.TITLE)
		{
			super.getDidulerList().getDidulerList().get(index).setTitle(fieldContent);
		}
		else if(field == ScheduleInfo.CONTENT)
		{
			super.getDidulerList().getDidulerList().get(index).setContent(fieldContent);
		}
		return true;
	}
	public boolean modify(Schedule schedule, ScheduleInfo field, boolean fieldContent)
	{
		int index = super.getDidulerList().getDidulerList().indexOf(schedule);
		if(index == -1)
			return false;
		if(field == ScheduleInfo.ISPUBLIC)
		{
			super.getDidulerList().getDidulerList().get(index).setIsPublic(fieldContent);
		}
		else if(field == ScheduleInfo.PRIORITY)
		{
			Schedule tmp = (Schedule)super.getDidulerList().getDidulerList().get(index);
			tmp.setPriority(fieldContent);
			
		}
		return true;
	}
	public boolean modify(Schedule schedule, ScheduleInfo field, Date fieldContent)
	{
		int index = super.getDidulerList().getDidulerList().indexOf(schedule);
		if(index == -1)
			return false;
		if(field == ScheduleInfo.START_DATE)
		{
			Schedule tmp = (Schedule)super.getDidulerList().getDidulerList().get(index);
			tmp.setStartDate(fieldContent);
		}
		else if(field == ScheduleInfo.END_DATE)
		{
			Schedule tmp = (Schedule)super.getDidulerList().getDidulerList().get(index);
			tmp.setEndDate(fieldContent);
			
		}
		return true;
	}
	public boolean modify(Schedule schedule, ScheduleInfo field, Alarm fieldContent)
	{
		int index = super.getDidulerList().getDidulerList().indexOf(schedule);
		if(index == -1)
			return false;
		if(field == ScheduleInfo.ALARM)
		{
			Schedule tmp = (Schedule)super.getDidulerList().getDidulerList().get(index);
			tmp.setAlarm(fieldContent);
		}
		return true;
	}
	public boolean remove()
	{
		return super.getDidulerList().getDidulerList().removeAll(super.getDidulerList().getDidulerList());
	}
	public boolean remove(int sel)
	{
		try
		{
			super.getDidulerList().getDidulerList().remove(sel);
			return true;
		}
		catch (IndexOutOfBoundsException e)
		{
			return false;
		}		
	}
	public boolean remove(int[] sel)
	{
		try
		{
			for(int cnt=0; cnt < sel.length; cnt++)
			{
				super.getDidulerList().getDidulerList().remove(sel[cnt]);
			}
			return true;
		}
		catch (IndexOutOfBoundsException e)
		{
			return false;
		}	
	}
	public Diduler[] search(SearchType t, String content)
	{
		Diduler[] array = new Diduler[]{};
		int size = super.getDidulerList().getDidulerList().size();
		for(int cnt=0; cnt<size; cnt++)
		{
			Diduler diduler = super.getDidulerList().getDidulerList().get(cnt);
			if(t == SearchType.TITLE)
			{
				if(diduler.getTitle().contains(content))
				{
					array[cnt] = diduler;
				}
			}
			else if(t == SearchType.TITLE_CONTENT)
			{
				if(diduler.getTitle().contains(content) || diduler.getContent().contains(content))
				{
					array[cnt] = diduler;
				}
			}
		}
		return array;
	}
	public Diduler[] search(Date date)
	{
		Diduler[] array = new Diduler[]{};
		int size = super.getDidulerList().getDidulerList().size();
		for(int cnt=0; cnt<size; cnt++)
		{
			Diduler diduler = super.getDidulerList().getDidulerList().get(cnt);
			if(diduler.getWrittenDate().equals(date))
			{
				array[cnt] = diduler;
			}
		}
		return array;
	}
	public String toString() {
		return "ScheduleManagement [scheduleList=" + super.getDidulerList() + "]";
	}
	
}
