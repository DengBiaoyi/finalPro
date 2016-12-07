package my.code.dao;

import java.sql.SQLException;

public interface Update {
	public boolean pass(String id)throws SQLException ;
	
	public boolean depass(String id,String reReason)throws SQLException ;
}
