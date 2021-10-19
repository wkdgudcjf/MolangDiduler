package diduler.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Select {
	public abstract ResultSet select()  throws Exception ;
	public abstract ResultSet select(String query) throws Exception ;
	
}
