package diduler.server;

import java.sql.ResultSet;
import java.util.List;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Translator {
	
	private ObjectInputStream in; 
	private ObjectOutputStream out;
	
	public Translator()
	{
		
	}
	
	public Translator(ObjectOutputStream out,ObjectInputStream in)
	{
		this.out=out;
		this.in=in;
	}
	public List<String[]> diaryToArray()
	{
		return null;
	}
	
	public List<String[]> memberToArray()
	{
		return null;
	}
	public List<String[]> scheduleToArray()
	{
		return null;
	}
	public List<String[]> contactToArray()
	{
		return null;
	}
	
	public void arrayToDiary(ResultSet rs)
	{
		
	}

	public void arrayToMember(ResultSet rs)
	{
		
	}
	public void arrayToSchedule(ResultSet rs)
	{
		
	}
	public void arrayToContact(ResultSet rs)
	{
		
	}
	
	
	public ObjectInputStream getIn() {
		return in;
	}

	public void setIn(ObjectInputStream in) {
		this.in = in;
	}

	public ObjectOutputStream getOut() {
		return out;
	}

	public void setOut(ObjectOutputStream out) {
		this.out = out;
	}
	
	

}
