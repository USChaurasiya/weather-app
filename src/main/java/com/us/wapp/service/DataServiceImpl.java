package com.us.wapp.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.us.wapp.model.History;
import com.us.wapp.model.User;
import com.us.wapp.model.WeatherInfo;
import com.us.wapp.repository.IHistoryRepository;
import com.us.wapp.repository.IUserRepository;

/**
 * Service class which is having all business logic related to the weather data.
 * @author UmaShankar
 * @since 14-Feb-2019
 *
 */
@Service
public class DataServiceImpl implements IDataService{
	
	@Autowired
	private IUserRepository iUserRepository;
	
	@Autowired
	private IHistoryRepository iHistoryRepository;

	@Value("${wapp.histry.uri}")
	private String weatherHistoryURL;
	
	@Value("${wapp.data.uri}")
	private String weatherURL;
	
	@Value("${wapp.data.api.key}")
	private String weatherAPIKey;
	
	
	@Autowired
	private RestTemplate restTemplate;
	

	@Override
	public WeatherInfo getWeatherInfoByLocation(String location, String email) {
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("q", location);
	    params.put("appid", weatherAPIKey);
	    WeatherInfo weatherInfo= restTemplate.exchange("http://"+weatherURL+"?q={q}&appid={appid}",
	    	    HttpMethod.GET,
	    	    null,
	    	    WeatherInfo.class, params
	    	).getBody();
	    User user =  iUserRepository.findByEmail(email);
	    History hs = new History();
	    hs.setHistoryTime(LocalDateTime.now());
	    hs.setSearchCity(location);
	    hs.setUser(user);
	    iHistoryRepository.save(hs);
	    
		return weatherInfo;
	}


	@Override
	public List<History> getAllHistoryByUser(String email) {
		User user = iUserRepository.findByEmail(email);
		List<History> histories = iHistoryRepository.findByUser(user.getId());
		return histories;
	}

}
