package diduler.server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleDAOManagement implements DAO{
	private Connection conn;
	private Statement stmt;
	private String jdbc_url;
	private String db_id;
	private String db_pw;
	//private Translator translator;
	public OracleDAOManagement()
	{
		
	}
	public OracleDAOManagement(String jdbc_url, String db_id, String db_pw)
	{
		
	}
	@Override
	public void close() {
		
	}
	@Override
	public void connect() {
		
	}
	@Override
	public int delete() {
		return 0;
	}
	@Override
	public int delete(String query) {
		return 0;
	}
	@Override
	public int insert() {
		return 0;
	}
	@Override
	public int insert(String query) {
		return 0;
	}
	@Override
	public ResultSet select() {
		return null;
	}
	@Override
	public ResultSet select(String query) {
		return null;
	}
	@Override
	public int update(String query) {
		return 0;
	}
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public Statement getStmt() {
		return stmt;
	}
	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}
	public String getJdbc_url() {
		return jdbc_url;
	}
	public void setJdbc_url(String jdbc_url) {
		this.jdbc_url = jdbc_url;
	}
	public String getDb_id() {
		return db_id;
	}
	public void setDb_id(String db_id) {
		this.db_id = db_id;
	}
	public String getDb_pw() {
		return db_pw;
	}
	public void setDb_pw(String db_pw) {
		this.db_pw = db_pw;
	}

}
	
