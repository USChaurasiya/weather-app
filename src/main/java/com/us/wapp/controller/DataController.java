package com.us.wapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.us.wapp.model.History;
import com.us.wapp.model.User;
import com.us.wapp.model.WeatherInfo;
import com.us.wapp.service.IDataService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/data")
public class DataController {
	
	@Autowired
	private IDataService IDataService;

	@ApiOperation(value = "Get All User", response = User.class, responseContainer = "List")
	@GetMapping("/history")
	public ResponseEntity<?> getallusers(@RequestHeader("Authorization") String token,
			HttpServletRequest req) throws Exception {
		
		String email =req.getAttribute("email").toString();
		List<History> hsList = IDataService.getAllHistoryByUser(email);
		return new ResponseEntity<List<History>>(hsList, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Search Location", response = Object.class, responseContainer = "List")
	@GetMapping("/search/{location}")
	public ResponseEntity<?> searchLocation(@RequestHeader("Authorization") String token,
			@PathVariable("location") String location, HttpServletRequest req) throws Exception {
		String email =req.getAttribute("email").toString();
		System.out.println(email);
		WeatherInfo winfo = IDataService.getWeatherInfoByLocation(location,email);
		
		return new ResponseEntity<WeatherInfo>(winfo,HttpStatus.OK);
	}
	
	
	
}
