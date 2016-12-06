package my.code.implDao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import my.code.dao.CheckUser;


public class CheckUserHelper implements CheckUser{

	@Override
	public boolean isRight(String name, String password) throws SQLException {
		if(!isExist(name)){
			System.out.println("该用户不存在");
			return false;
		}
		
		MysqlImpl mysql = MysqlImpl.getInstance();
		mysql.connect();
		String sql = "select * from users where name= ? and password = ?;";
		PreparedStatement preparedStatement = mysql.execute(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			mysql.close();
			return true;
			
		}else {
			mysql.close();
			return false;
		}
	}

	@Override
	public boolean isExist(String name) throws SQLException {
		MysqlImpl mysql = MysqlImpl.getInstance();
		mysql.connect();
		String sql = "select * from users where name= ?;";
		PreparedStatement preparedStatement = mysql.execute(sql);
		preparedStatement.setString(1, name);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			mysql.close();
			return true;
			
		}else {
			mysql.close();
			return false;
		}
	}

}
