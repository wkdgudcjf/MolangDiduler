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
				Socket socket = server.accept(); //Ŭ���̾�Ʈ ���� ���
				check.login(socket); //�����ϴ¼��� login�޼ҵ� ����.
			}
			catch(Exception ioe)
			{
				ioe.printStackTrace();
			}
		}
	}
}
