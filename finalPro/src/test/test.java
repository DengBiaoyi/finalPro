package test;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import my.code.dao.GetUserInfo;
import my.code.dao.Mysql;
import my.code.implDao.CheckUserHelper;
import my.code.implDao.GetUserInfoImpl;
import my.code.implDao.LeaveImpl;
import my.code.implDao.MysqlImpl;
import my.code.implDao.RegisterUserImpl;
import my.code.object.User;
import my.code.object.UserInfo;
import my.code.utils.MD5;


public class test {
	public static void main(String [] str) throws SQLException{
//		MysqlImpl mysql = MysqlImpl.getInstance();
//		mysql.connect();
//		String sql = "select * from users where name = '小小' and password= '123456'";
//		PreparedStatement pst = mysql.execute(sql);
//		
//		ResultSet resultSet = pst.executeQuery();
//		
//		
//		while(resultSet.next()){
//			System.out.println(resultSet.getString(2));
//			
//		}
//		CheckUserHelper aCheckHelper=new CheckUserHelper();
		
//		String string = "123456";
//		System.out.println(MD5.getMD5(string));
		
//		UserInfo userInfo = new UserInfo("小小", "程序员", "开发部");
//		User user = new User(userInfo, MD5.getMD5("123456"));
//		RegisterUserImpl re = new RegisterUserImpl();
//		System.out.println(re.register(user));
//		GetUserInfoImpl userInfoImpl = new GetUserInfoImpl();
//		UserInfo user = userInfoImpl.getUserInfo("小小");
//		user.print();
//		UserInfo user = new UserInfo("小小", "程序员", "开发部");
//		LeaveImpl leave = new LeaveImpl();
//		Date date = new Date(2016-1900,1-1,1);
//		
//		leave.addLeave(user, date, 10, "病假", "嘿嘿");
		String string=null;
		if(string!=null&(string="11")=="11"){
			
		}
		System.out.println(string);	
		
	}
}
