package com.acme.threadlocal_transactional;

import java.sql.SQLException;

public class UserManagerImpl implements UserManager {
	private UserDAO userDAO = null;

	public UserManagerImpl() {
		userDAO = new UserDAOImpl();
	}

	public User findUser(String id) throws SQLException {
		return userDAO.selUser(id);
	}
}