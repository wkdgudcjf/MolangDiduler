package diduler.server.dao;

import java.sql.SQLException;
import java.util.Scanner;


public class DaoThread extends Thread{
	private DAOManager manager;
	public DaoThread() throws ClassNotFoundException, SQLException
	{
		this(new OracleDAOManagement());
	}
	public DaoThread(DAOManager manager) throws SQLException
	{
		this.manager = manager;
		manager.connect();
	}
	public void run()
	{
		Scanner in = new Scanner(System.in);
		try {
			while(true)
			{
				String input = in.nextLine();
				if(input.equalsIgnoreCase("save"))
				{
					manager.delete();
					manager.insert();
				}
				else if(input.equalsIgnoreCase("load"))
				{
					manager.select();
				}
				else if(input.equalsIgnoreCase("exit"))
				{
					manager.close();
					throw new Exception();
				}
			}

		} catch (Exception e) {
		}
	}
	public static void main(String args[])
	{
		try {
			new DaoThread().start();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
