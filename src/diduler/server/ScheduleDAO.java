package diduler.server;

import java.sql.ResultSet;
import java.sql.Statement;

public class ScheduleDAO implements DAO{
	private Statement stmt;
	
	
	public ScheduleDAO(Statement stmt)
	{
		
	}
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultSet select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet select(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(String query) {
		// TODO Auto-generated method stub
		return 0;
	}
	public Statement getStmt() {
		return stmt;
	}
	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}
}
