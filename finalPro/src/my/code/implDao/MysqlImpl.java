package my.code.implDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import my.code.dao.Mysql;


public class MysqlImpl implements Mysql{
	private Connection conn = null;
	private static MysqlImpl instance=null;
	private boolean isClose = true;
	
	@Override
	public Connection connect() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test1";
			String username = "root";
			String password = "";
			conn = DriverManager.getConnection(url,username,password);
			isClose = false;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return conn;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		isClose = true;
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean isClose(){
		return isClose;
	}
	
	private MysqlImpl(){};
	
	public static synchronized MysqlImpl getInstance(){

		if(instance == null){
			instance = new MysqlImpl();
		}
		return instance;
	}

	@Override
	public PreparedStatement execute(String str) {
		if(!isClose){
			PreparedStatement result = null;
			try {
				result = conn.prepareStatement(str);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}else{
			System.err.println("数据库未连接");
			return null;
		}
		
	}

}
