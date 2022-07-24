package com.acme.threadlocal_transactional;



import java.sql.SQLException;

public interface UserDAO {
	public User selUser(String id) throws SQLException;
}