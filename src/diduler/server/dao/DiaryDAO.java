package diduler.server.dao;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DiaryDAO implements DAO{

	private Statement stmt;
	
	public DiaryDAO()
	{
		
	}
	
	public DiaryDAO(Statement stmt)
	{
		this.stmt=stmt;
	}

	public ResultSet select() throws SQLException
	{
		ResultSet rs = stmt.executeQuery("select * from diary_tb");
		return rs;
	}
	
	public ResultSet select(String query) throws SQLException
	{
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}
	public int delete() throws SQLException
	{
		return stmt.executeUpdate("delete from diary_tb");
	}
	public int delete(String query) throws SQLException
	{
		return stmt.executeUpdate(query);
	}
	
	public int insert(String query) throws SQLException
	{
		return stmt.executeUpdate(query);
	}
	
	public int update(String query) throws SQLException
	{
		return stmt.executeUpdate(query);
	}
	
	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	@Override
	public void close() throws SQLException {
		stmt.close();
	}


	
}
