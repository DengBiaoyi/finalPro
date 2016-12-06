package my.code.implDao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import my.code.dao.Leave;
import my.code.object.UserInfo;

public class LeaveImpl implements Leave{

	@Override
	public boolean addLeave(UserInfo user, Date date, int leaveDay,
			String type, String reason) throws SQLException {
		MysqlImpl mysql = MysqlImpl.getInstance();
		mysql.connect();
		String sql = "insert into test1.leave ( name,department,job,date,leaveDay,type,"
				+ "reason ) value (?,?,?,?,?,?,?)";
		PreparedStatement prst = mysql.execute(sql);
		prst.setString(1, user.getName());
		prst.setString(2, user.getDepartment());
		prst.setString(3, user.getJob());
		prst.setDate(4, date);
		prst.setInt(5, leaveDay);
		prst.setString(6, type);
		prst.setString(7, reason);
		prst.execute();
		mysql.close();
		return true;
	}

}
