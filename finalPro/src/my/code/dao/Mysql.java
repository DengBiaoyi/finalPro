package my.code.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public interface Mysql {
	public Connection connect();
	public PreparedStatement execute(String str);
	public void close();
}
