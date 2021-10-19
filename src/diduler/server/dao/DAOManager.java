package diduler.server.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public interface DAOManager extends Close{
	public abstract void connect() throws SQLException;
	public abstract int delete() throws SQLException;
	public abstract int insert() throws SQLException, FileNotFoundException, ClassNotFoundException, IOException;
	public abstract ResultSet select() throws FileNotFoundException, SQLException, IOException;
}
