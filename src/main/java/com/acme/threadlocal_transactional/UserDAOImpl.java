package com.acme.threadlocal_transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
	// 根据ID查询用户
	public User selUser(String id) throws SQLException {
		ResultSet resu = null;
		String sql = "SELECT * FROM T_USER WHERE USER_ID = ?";
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		User user = null;
		try {
			pstat.setString(1, id);
			resu = pstat.executeQuery();
			while (resu.next()) {
				user = getUser(resu);
			}
		} finally {
			if (resu != null) {
				resu.close();
			}
			if (pstat != null) {
				pstat.close();
			}
		}
		return user;
	}

	// 获取用户
	private User getUser(ResultSet resu) throws SQLException {
		User user = new User();
		user.setId(resu.getString("USER_ID"));
		user.setName(resu.getString("USER_NAME"));
		user.setPassword(resu.getString("PASSWORD"));
		user.setContact_tel(resu.getString("CONTACT_TEL"));
		user.setEmail(resu.getString("EMAIL"));
		user.setCreate_date(resu.getTimestamp("CREATE_DATE"));
		return user;
	}
}