package diduler.server;

import java.io.IOException;
import java.net.*;
import diduler.server.dao.DaoThread;

public class Server 
{
	private ServerSocket serverSocket;
	
	public Server() throws IOException
	{
		this.serverSocket=new ServerSocket(9000);
	}
	
	public Server(int port) throws IOException
	{
		this.serverSocket=new ServerSocket(port);
	}
	
	public Socket accept() throws IOException
	{
		Socket socket=serverSocket.accept();
		return socket;
	}

	public void serverClose() throws IOException
	{
		this.serverSocket.close();
	}
	public ServerSocket getServerSocket() {
		return serverSocket;
	}
	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	public static void main(String[] args) {
		Server logins;
		Server logouts;
		try {
			new DaoThread().start();
			logins = new Server(9100);
			logouts = new Server(9001);
			CheckClient check = new CheckClient();
			LoginThread login = new LoginThread(logins);
			LogoutThread logout = new LogoutThread(logouts);
			login.setCheck(check);
			logout.setCheck(check);
			
			login.start();
			logout.start();	
			
		} catch (Exception e) {
		}
		
		
		
	}
}
