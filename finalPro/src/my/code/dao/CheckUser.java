package my.code.dao;

import java.sql.SQLException;

public interface CheckUser {
	public boolean isExist(String name)throws SQLException;
	public boolean isRight(String name,String password)throws SQLException;
}
