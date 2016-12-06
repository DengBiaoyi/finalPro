package my.code.implDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.event.ChangeListener;

import my.code.dao.ChangePwd;

public class ChangePwdImpl extends CheckUserHelper implements ChangePwd{

	@Override
	public boolean changePwd(String name, String password,String newPassword) throws SQLException {
		if(isExist(name)&&isRight(name, password)){
			String string = "update users set password = ? where name=? and password=?";
			MysqlImpl mysql = MysqlImpl.getInstance();
			mysql.connect();
			PreparedStatement prst = mysql.execute(string);
			prst.setString(1, newPassword);
			prst.setString(2, name);
			prst.setString(3, password);		
			prst.execute();
			mysql.close();
			
			return true;
		}
		return false;
	}
	
}
