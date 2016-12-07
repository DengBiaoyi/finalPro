package my.code.implDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import my.code.dao.Update;

public class UpdateImpl implements Update{

	@Override
	public boolean pass(String id) throws SQLException {
		MysqlImpl mysql = MysqlImpl.getInstance();
		mysql.connect();
		String sql = "update test1.leave set isPass='通过' where id=?";
		PreparedStatement prst = mysql.execute(sql);
		prst.setString(1, id);
		prst.execute();
		mysql.close();
		return true;
	}

	@Override
	public boolean depass(String id, String reReason) throws SQLException {
		MysqlImpl mysql = MysqlImpl.getInstance();
		mysql.connect();
		String sql = "update test1.leave set isPass='未通过' , reReason=? where id=?";
		PreparedStatement prst = mysql.execute(sql);
		prst.setString(1, reReason);
		prst.setString(2, id);
		prst.execute();
		mysql.close();
		return true;
	}

}
