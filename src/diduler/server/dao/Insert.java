package diduler.server.dao;

import java.sql.SQLException;

public interface Insert {
	public abstract int insert(String query) throws SQLException ;
}
