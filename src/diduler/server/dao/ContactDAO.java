package diduler.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ContactDAO implements DAO{
	private Statement stmt;
	
	public ContactDAO()
	{
		
	}
	public ContactDAO(Statement stmt)
	{
		this.stmt = stmt;
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
	@Override
	public int delete() throws SQLException {
		return stmt.executeUpdate("delete from contact_tb");
	}
	@Override
	public int delete(String query) throws SQLException {
		return stmt.executeUpdate(query);
	}
	@Override
	public int insert(String query) throws SQLException {
		return stmt.executeUpdate(query);
	}
	@Override
	public ResultSet select() throws SQLException {
		return stmt.executeQuery("select * from contact_tb");
	}
	@Override
	public ResultSet select(String query) throws SQLException {
		return stmt.executeQuery(query);
	}
	@Override
	public int update(String query) throws SQLException {
		return stmt.executeUpdate(query);
	}
}
