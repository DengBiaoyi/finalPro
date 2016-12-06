package my.code.dao;

import java.sql.Date;
import java.sql.SQLException;

import my.code.object.UserInfo;

public interface Leave {
	public boolean addLeave(UserInfo user,Date date,int leaveDay
			,String type,String reason) throws SQLException ;
}
