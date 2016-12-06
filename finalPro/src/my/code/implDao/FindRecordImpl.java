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

	@Override
	public ResultSet findRecordByName(MysqlImpl mysql, String name)
			throws SQLException {
		return findMyRecord(mysql, name);
	}

	@Override
	public ResultSet findRecordByNameStartX(MysqlImpl mysql, String name,
			int x, int n) throws SQLException {
		return findMyRecordStartX(mysql, name, x, n);
	}

	@Override
	public ResultSet findRecordByDepartment(MysqlImpl mysql, String department)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet findRecordByDepartmentStartX(MysqlImpl mysql,
			String department, int x, int n) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet findRecordByNameAndDepartment(MysqlImpl mysql,
			String name, String department) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet findRecordByNameAndDepartmentStartX(MysqlImpl mysql,
			String name, String department, int x, int n) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
