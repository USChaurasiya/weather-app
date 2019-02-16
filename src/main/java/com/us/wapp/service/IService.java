package com.us.wapp.service;

import com.us.wapp.model.User;

/**
 * @author UmaShankar
 * @since 14-Feb-2019
 */
public interface IService {

	public int addUser(User user)throws Exception;
	
	public String login(User user);
}
