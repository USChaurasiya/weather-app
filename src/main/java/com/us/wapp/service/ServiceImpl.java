package com.us.wapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.us.wapp.model.User;
import com.us.wapp.repository.IUserRepository;
import com.us.wapp.util.TokenService;

/**
 * This Class contains the business logics related to the User and weather Data.
 * @author UmaShankar
 * @since 14-Feb-2019
 */
@Service
public class ServiceImpl implements IService{

	@Autowired
	private IUserRepository iUserRepository;
	
	@Autowired
	private TokenService tokenService;
	
	@Override
	public int addUser(User user) throws Exception {
		if(iUserRepository.existByEmail(user.getEmail())) {
			throw new Exception("User with the given email is Already Exist in Data Base..");
		}
		int id = iUserRepository.save(user).getId();
		return id;
	}

	@Override
	public String login(User user) {
		User u = iUserRepository.loginUser(user.getEmail(), user.getPassword());
		System.out.println(u.toString());
		
		return tokenService.generateToken(user.getEmail());
	}

}
