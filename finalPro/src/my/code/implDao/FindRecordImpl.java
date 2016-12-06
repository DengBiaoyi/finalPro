package my.code.implDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import my.code.dao.FindRecord;

public class FindRecordImpl implements FindRecord{

	@Override
	public ResultSet findMyRecord(MysqlImpl mysql, String name) 
			throws SQLException {
		String sql = "select * from test1.leave where name = ?order by date,leaveDay";
		PreparedStatement prst = mysql.execute(sql);
		prst.setString(1, name);
		ResultSet resultSet = prst.executeQuery();
		return resultSet;
	}

	@Override
	public ResultSet findMyRecordStartX(MysqlImpl mysql, String name, int x,
			int n) throws SQLException {
		String sql = "select * from test1.leave where name = ? order by date,leaveDay limit ?,?;";
		PreparedStatement prst = mysql.execute(sql);
		prst.setString(1, name);
		prst.setInt(2, x);
		prst.setInt(3, n);
		ResultSet resultSet = prst.executeQuery();
		return resultSet;
	}

}
