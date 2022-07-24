package com.acme.threadlocal_transactional;

public interface UserManager {
	public User findUser(String id) throws Exception;
}