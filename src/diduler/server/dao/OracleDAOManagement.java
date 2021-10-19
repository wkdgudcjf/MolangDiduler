package diduler.server.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class OracleDAOManagement implements DAOManager{
	private Connection conn;
	private Statement stmt;
	private String jdbc_url;
	private String db_id;
	private String db_pw;
	
	public OracleDAOManagement() throws ClassNotFoundException
	{
		this("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
	}
	public OracleDAOManagement(String jdbc_url, String db_id, String db_pw) throws ClassNotFoundException
	{
		this.jdbc_url = jdbc_url;
		this.db_id = db_id;
		this.db_pw = db_pw;
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}
	@Override
	public void close() throws SQLException {
		stmt.close();
		conn.close();
	}
	@Override
	public void connect() throws SQLException {
		conn = DriverManager.getConnection(jdbc_url, db_id, db_pw);
		stmt = conn.createStatement();
		conn.setAutoCommit(true);
	}
	@Override
	public int delete() throws SQLException {
		new DiaryDAO(stmt).delete();
		new ScheduleDAO(stmt).delete();
		new ContactDAO(stmt).delete();
		new MemberDAO(stmt).delete();

		return 0;
	}
	@Override
	public int insert() throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
		Translator trans = new Translator();
		
		List<String[]> list;
		
		try {
			list = trans.diaryToArray();
			DiaryDAO diary = new DiaryDAO(stmt);
			for(int i=0; i<list.size(); i++)
				diary.insert("insert into diary_tb values ('"+list.get(i)[0]+"','"+list.get(i)[1]+"','"+list.get(i)[2]+"','"+list.get(i)[3]+"','"+list.get(i)[4]+"','"+list.get(i)[5]+"')");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			MemberDAO member = new MemberDAO(stmt);
			list = trans.memberToArray();
			for(int i=0; i<list.size(); i++)
				member.insert("insert into member_tb values ('"+list.get(i)[0]+"','"+list.get(i)[1]+"','"+list.get(i)[2]+"','"+list.get(i)[3]+"','"+list.get(i)[4]+"','"+list.get(i)[5]+"','"+list.get(i)[6]+"','"+list.get(i)[7]+"')");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			ScheduleDAO schedule = new ScheduleDAO(stmt);
			list = trans.scheduleToArray();
			for(int i=0; i<list.size(); i++)
				schedule.insert("insert into schedule_tb values ('"+list.get(i)[0]+"','"+list.get(i)[1]+"','"+list.get(i)[2]+"','"+list.get(i)[3]+"','"+list.get(i)[4]+"','"+list.get(i)[5]+"')");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			ContactDAO contact =new ContactDAO(stmt);
			list = trans.contactToArray();
			for(int i=0; i<list.size(); i++)
				contact.insert("insert into contact_tb values ('"+list.get(i)[0]+"','"+list.get(i)[1]+"','"+list.get(i)[2]+"','"+list.get(i)[3]+"','"+list.get(i)[4]+"','"+list.get(i)[5]+"')");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	@Override
	public ResultSet select() throws FileNotFoundException, SQLException, IOException {
		Translator trans = new Translator();
		
		trans.arrayToDiary(new DiaryDAO(stmt).select());
		trans.arrayToContact(new ContactDAO(stmt).select());
		trans.arrayToMember(new MemberDAO(stmt).select());
		trans.arrayToSchedule(new ScheduleDAO(stmt).select());
		return null;
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
	public static void main(String args[])
	{
		try {
			OracleDAOManagement manage =new OracleDAOManagement();
			manage.connect();
			//manage.select();
			manage.delete();
			manage.insert();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
	
