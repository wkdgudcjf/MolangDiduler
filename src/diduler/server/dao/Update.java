package diduler.server.dao;

import java.sql.SQLException;

public interface Update {
	public abstract int update(String query) throws SQLException ;
}
