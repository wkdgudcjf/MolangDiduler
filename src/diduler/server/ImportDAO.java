package diduler.server;

import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.List;

import diduler.mainUI.ContactController;
import diduler.mainUI.DiaryController;
import diduler.member.MemberList;
import diduler.model.diary.DiaryList;
import diduler.model.diary.DiaryManagement;
import diduler.model.person.PersonGroup;
import diduler.model.person.PersonManagement;
import diduler.model.schedule.ScheduleList;

public class ImportDAO 
{
	private InputStream in;
	private String id;

	public ImportDAO() 
	{
		this.in = null;
		this.id = null;
	}

	public InputStream getIn() 
	{
		return in;
	}

	public void setIn(InputStream in) 
	{
		this.in = in;
	}

	public String getId() 
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public ImportDAO(String id, Socket socket) throws Exception 
	{
		this.id = id;
		in = socket.getInputStream();
	}

	public ImportDAO(String id, InputStream in)
	{
		this.id = id;
		this.in = in;
	}

	public void importAll()
	{
		importFile();
	}
		//importMainImg();
		//importDiary();
		
		//importSchedule();
		//importContact();
		
	private void importFile()
	{
		BufferedInputStream input = null;  //นÞดย input
		BufferedOutputStream fi = null;
		try
		{
			   input = new BufferedInputStream(in); 
			   fi =	new BufferedOutputStream(new FileOutputStream("import_"+id+".zip"));
			   int c;
			   DataInputStream din = new DataInputStream(in);
			   long size = din.readLong();

				while (size!=0) {
					c=input.read();
					fi.write(c);
					size--;
				}
			   fi.flush();
			   fi.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
	
