package com.us.wapp.model;

import java.util.Arrays;

public class WeatherInfo {

	private Coord coord;

	private Weather[] weather;

	private Main main;

	private Wind wind;

	private Sys sys;

	private String name;

	private String base;

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public Weather[] getWeather() {
		return weather;
	}

	public void setWeather(Weather[] weather) {
		this.weather = weather;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	@Override
	public String toString() {
		return "WeatherInfo [coord=" + coord + ", weather=" + Arrays.toString(weather) + ", main=" + main + ", wind="
				+ wind + ", sys=" + sys + ", name=" + name + ", base=" + base + "]";
	}

	
	
}
