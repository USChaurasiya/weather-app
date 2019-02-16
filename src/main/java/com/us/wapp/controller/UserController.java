package com.us.wapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.us.wapp.model.User;
import com.us.wapp.service.IService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IService iService;

	@ApiOperation(value = "Register New User", response = User.class, responseContainer = "Object")
	@PostMapping("/register")
	public ResponseEntity<?> saveApplicantData(@Valid @RequestBody User user, BindingResult result) throws Exception {

		int userId = iService.addUser(user);
		return new ResponseEntity<String>("User with id " + userId + " registered Successfully!!!", HttpStatus.OK);
	}
	
	@ApiOperation(value = "Login Existing User", response = String.class, responseContainer = "Object")
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@Valid @RequestBody User user, BindingResult result) throws Exception {

		String token = iService.login(user);
		return new ResponseEntity<String>("User Logged In having access Token as :  " + token , HttpStatus.OK);
	}

}
