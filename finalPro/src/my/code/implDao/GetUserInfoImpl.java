package my.code.implDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jboss.weld.bean.builtin.ee.UserTransactionBean;
import org.omg.CORBA.UShortSeqHolder;

import my.code.dao.GetUserInfo;
import my.code.object.UserInfo;

public class GetUserInfoImpl implements GetUserInfo{

	@Override
	public UserInfo getUserInfo(String name) throws SQLException {
		MysqlImpl mysql = MysqlImpl.getInstance();
		mysql.connect();
		String sql = "select * from users where name = ?";
		PreparedStatement prst = mysql.execute(sql);
		prst.setString(1, name);
		ResultSet result = prst.executeQuery();
		if(result.next()){
			UserInfo userInfo = new UserInfo(result.getString(2), result.getString(4), result.getString(3));
//			for(int i=1;i<8;i++){
//				System.out.println(i+" "+result.getString(i));
//			}
			mysql.close();
			return userInfo;
		}else{
			return null;
		}
		
	}

}
