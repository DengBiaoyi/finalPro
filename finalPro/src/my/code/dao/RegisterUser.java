package my.code.dao;

import java.sql.SQLException;

import my.code.object.User;

public interface RegisterUser {
	public boolean register(User user)  throws SQLException ;
}
