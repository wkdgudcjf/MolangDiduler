package diduler.server.dao;

import java.sql.SQLException;

public interface Delete {
	public abstract int delete() throws SQLException ;
	public abstract int delete(String query) throws SQLException ;
}
