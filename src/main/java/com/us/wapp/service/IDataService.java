package com.us.wapp.service;

import java.util.List;

import com.us.wapp.model.History;
import com.us.wapp.model.WeatherInfo;

/**
 * @author UmaShankar
 * @since 14-Feb-2019
 *
 */
public interface IDataService {

	/**
	 * To get the Weather information By passing the Location or city Name
	 * @param location
	 * @return Object
	 */
	public WeatherInfo getWeatherInfoByLocation(String location, String email);
	
	/**
	 * To Fetch all history of User
	 * @param email
	 * @return
	 */
	public List<History> getAllHistoryByUser(String email);
	
}
