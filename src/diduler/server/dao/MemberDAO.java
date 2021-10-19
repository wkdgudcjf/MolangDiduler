package diduler.server.dao;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.sql.*;


public class MemberDAO implements DAO{

	private Statement stmt;

	public MemberDAO() {

	}

	public MemberDAO(Statement stmt) {
		this.stmt = stmt;
	}

	public ResultSet select() throws SQLException {
		return stmt.executeQuery("select * from member_tb");
	}

	public ResultSet select(String query) throws SQLException {
		return stmt.executeQuery(query);
	}

	public int delete() throws SQLException {
		return stmt.executeUpdate("delete from member_tb");
	}

	public int delete(String query) throws SQLException {
		return stmt.executeUpdate(query);
	}

	public int insert(String query) throws SQLException {
		return stmt.executeUpdate(query);
	}

	public int update(String query) throws SQLException {
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
