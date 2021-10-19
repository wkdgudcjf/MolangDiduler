package diduler.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class LogoutThread extends Thread
{
	private Server server;
	private CheckClient check;
	public LogoutThread()
	{
		;
	}
	public LogoutThread(Server server)
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
				Socket socket = server.accept(); //접속대기
				check.logout(socket); // 접속하는순간 로그아웃메소드호출.
			}
			catch(Exception ioe)
			{
				ioe.printStackTrace();
			}
		}
	}
}
