package diduler.model.calendar;

import java.util.Date;

public class Holiday {
	private Date date;
	private String name;
	
	public Holiday()
	{
		this(null,"");
	}
	public Holiday(Date date, String name)
	{
		this.date = date;
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
