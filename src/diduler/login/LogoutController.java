package diduler.login;

import java.net.*;
import java.io.*;

import diduler.model.backup.BackUp;
import diduler.model.backup.DiaryBackUp;
import diduler.model.backup.PersonBackUp;
import diduler.model.backup.ScheduleBackUp;

public class LogoutController {
	private String id;

	public LogoutController() throws IOException
	{
		BufferedReader filein = new BufferedReader(new FileReader("id.txt"));
		id = filein.readLine();
		
	}
	public LogoutController(String id)
	{
		this.id=id;
	}
	private void exportFile(OutputStream out)
	{
		DiaryBackUp.exportDiary();
		ScheduleBackUp.exportSchedule();
		PersonBackUp.exportPerson();
		try {
			DiaryBackUp.imageToFile();
			BackUp.allExport(out);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//BackUp.exportMainimage(out);
		
		//DiaryBackUp.exportDiary(out);
		/*
		ScheduleBackUp.exportSchedule(out);
		PersonBackUp.exportPerson(out);		
		*/
	}
	private void close(Socket socket) throws Exception
	{
		socket.close();
	}
	public boolean connect(String ip, int port) throws Exception
	{
		Socket socket = new Socket(ip,port);
		PrintWriter write = new PrintWriter(socket.getOutputStream());
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		write.println(id);
		write.flush();
		String str = reader.readLine();
		if(str.equals("yes"))
		{
			exportFile(socket.getOutputStream());
			close(socket);
			return true;
		}
		else
		{
			close(socket);
			return false;
		}
	}
	public boolean connect(Socket socket) throws Exception
	{
		PrintWriter write = new PrintWriter(socket.getOutputStream());
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		write.println(id);
		String str = reader.readLine();
		if(str.equals("yes"))
		{
			exportFile(socket.getOutputStream());
			close(socket);
			return true;
		}
		else
		{
			close(socket);
			return false;
		}	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
