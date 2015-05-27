package com;

import com.Hotel;

public class City {

	public String name;
	Hotel[] hotels;

	public City(String name, Hotel[] hotels) {
		this.name = name;
		this.hotels = hotels;
	}

	public String getName() {
		return this.name;
	}

}
