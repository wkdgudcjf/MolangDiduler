package diduler.login;

import java.net.*;
import java.io.*;

import javax.swing.JOptionPane;

import diduler.model.backup.*;

public class LoginController {
	private String id;
	private String pw;
	
	public LoginController()
	{
		;
	}
	public LoginController(String id, String pw)
	{
		this.id=id;
		this.pw=pw;
	}
	private void importFile(InputStream in)
	{
		BackUp.allImport(in);
		DiaryBackUp.fileToImage();
		DiaryBackUp.importDiary();
		ScheduleBackUp.importSchedule();
		PersonBackUp.importPerson();
		
	}
	private void close(Socket socket) throws Exception 
	{
		socket.close();
	}
	public String connect(String ip, int port) throws Exception
	{
		Socket socket = new Socket(ip,port);
		PrintWriter fileout = new PrintWriter(new File("id.txt"));
		fileout.println(id);
		fileout.flush();
		fileout.close();
		
		PrintWriter write = new PrintWriter(socket.getOutputStream());
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		write.println(id);
		write.println(pw);
		write.flush();
		String str = reader.readLine();
		if(str.length()!=0)
		{
			importFile(socket.getInputStream());
			close(socket);
			return str;
		}
		else
		{
			JOptionPane.showConfirmDialog(null,"아이디와 비밀번호를 확인해 주세요","Error Message", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			close(socket);
			return null;
		}
	}
	public boolean connect(Socket socket)
	{
		return true;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
}
