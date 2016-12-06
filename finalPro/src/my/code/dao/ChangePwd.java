package my.code.dao;

import java.sql.SQLException;

public interface ChangePwd {
	public boolean changePwd(String name,String password,String newPassword)throws SQLException ;
}
