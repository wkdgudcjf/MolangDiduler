package diduler.server;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class DiaryDAO {

	private Statement stmt;
	
	public DiaryDAO()
	{
		
	}
	
	public DiaryDAO(Statement stmt)
	{
		this.stmt=stmt;
	}

	public ResultSet select()
	{
		return null;
	}
	
	public ResultSet select(String query)
	{
		return null;
	}
	public int delete()
	{
		return 0;
	}
	public int delete(String query)
	{
		return 0;
	}
	
	public void insert()
	{
		
	}
	public void insert(String query)
	{
		
	}
	
	public void update(String query)
	{
		
	}
	
	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}
	

	
}
