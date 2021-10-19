package diduler.model.schedule;
import java.io.Serializable;
import java.util.*;
import diduler.model.diduler.*;

public class Schedule extends Diduler implements Serializable{

	private boolean priority;
	private Alarm alarm;
	private Date startDate;
	private Date endDate;
	
	public Schedule(String title, String content) {
		this(title, content, true, false, new Date(), new Date(), null);
	}
	public Schedule(String title, String content, boolean isPublic) {
		this(title, content, isPublic, false, new Date(), new Date(), null);
	}
	public Schedule(String title, String content, Date startDate, Date endDate) {
		this(title, content, false, true, startDate, endDate, null);
	}
	public Schedule(String title, String content, boolean priority, Date startDate, Date endDate, Alarm alarm) {
		this(title, content,priority, true, startDate, endDate, alarm);
	}
	public Schedule(String title, String content, boolean priority, boolean isPublic, Date startDate, Date endDate) {
		this(title, content, priority, isPublic, startDate, endDate, null);
	}	
	public Schedule(String title, String content, boolean priority, boolean isPublic, Date startDate,Date endDate, Alarm alarm) {
		super(title, content, isPublic);
		this.priority = priority;
		this.alarm = alarm;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	
	public boolean getPriority() {
		return priority;
	}
	public void setPriority(boolean priority) {
		this.priority = priority;
	}
	public Alarm getAlarm() {
		return alarm;
	}
	public void setAlarm(Alarm alarm) {
		this.alarm = alarm;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String toString() {
		return "Schedule [title=" + super.getTitle() + ", content=" + super.getContent()
				+ ", priority=" + priority + ", isPublic=" + super.getIsPublic()
				+ ", writtenDate=" + super.getWrittenDate() + ", alarm=" + alarm
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}	
}
