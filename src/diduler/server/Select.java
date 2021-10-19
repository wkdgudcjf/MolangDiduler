package diduler.server;

import java.sql.ResultSet;

public interface Select {
	public abstract ResultSet select();
	public abstract ResultSet select(String query);
	
}
