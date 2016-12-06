package my.code.implDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import my.code.dao.RegisterUser;
import my.code.object.User;

public class RegisterUserImpl implements RegisterUser {

	@Override
	public boolean register(User user) throws SQLException{
		CheckUserHelper helper = new CheckUserHelper();
		if(helper.isExist(user.getUserInfo().getName())){
			System.out.println("该用户名已被使用");
			return false;
		}
		MysqlImpl mysql = MysqlImpl.getInstance();
		mysql.connect();
		String sql = "insert into users (name,department,job,password) value(?,?,?,?)";
		PreparedStatement prst = mysql.execute(sql);
		prst.setString(1, user.getUserInfo().getName());
		prst.setString(2, user.getUserInfo().getDepartment());
		prst.setString(3, user.getUserInfo().getJob());
		prst.setString(4, user.getPassword());
		prst.execute();
		mysql.close();
		return true;

	}

}
