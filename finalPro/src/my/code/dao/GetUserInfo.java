package my.code.dao;

import java.sql.SQLException;


import my.code.object.UserInfo;

public interface GetUserInfo{
	public UserInfo getUserInfo(String name)throws SQLException;
}
