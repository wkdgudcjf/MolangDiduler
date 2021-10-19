package diduler.server;

import java.net.*;
import java.io.*;

public class LoginThread extends Thread
{
	private Server server;
	private CheckClient check; 
	public LoginThread()
	{
		;
	}
	public LoginThread(Server server)
	{
		this.server=server;
	}
	public Server getServer() {
		return server;
	}
	public void setServer(Server server) {
		this.server = server;
	}
	public CheckClient getCheck() {
		return check;
	}
	public void setCheck(CheckClient check) {
		this.check = check;
	}
	
	public void run()
	{
		while(true)
		{
			try
			{
				Socket socket = server.accept(); //클라이언트 접속 대기
				check.login(socket); //접속하는순간 login메소드 실행.
			}
			catch(Exception ioe)
			{
				ioe.printStackTrace();
			}
		}
	}
}
