package my.code.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.DocFlavor.STRING;

import my.code.implDao.MysqlImpl;

public interface FindRecord {
	public ResultSet findMyRecord(MysqlImpl mysql,String name)throws SQLException ;
	public ResultSet findMyRecordStartX(MysqlImpl mysql,String name,int x,int n)throws SQLException ;
}
