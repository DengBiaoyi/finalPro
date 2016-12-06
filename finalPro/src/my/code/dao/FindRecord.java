package my.code.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.DocFlavor.STRING;

import my.code.implDao.MysqlImpl;

public interface FindRecord {
	public ResultSet findMyRecord(MysqlImpl mysql,String name)throws SQLException ;
	public ResultSet findMyRecordStartX(MysqlImpl mysql,String name,int x,int n)throws SQLException ;
	
	public ResultSet findRecordByName(MysqlImpl mysql,String name)throws SQLException ;
	public ResultSet findRecordByNameStartX(MysqlImpl mysql,String name,int x,int n)throws SQLException ;
	
	public ResultSet findRecordByDepartment(MysqlImpl mysql,String department) throws SQLException ;
	public ResultSet findRecordByDepartmentStartX(MysqlImpl mysql,String department,int x,int n) throws SQLException ;
	
	public ResultSet findRecordByNameAndDepartment(MysqlImpl mysql,String name,String department)throws SQLException;
	public ResultSet findRecordByNameAndDepartmentStartX(MysqlImpl mysql,String name,String department,int x,int n)throws SQLException;
}
