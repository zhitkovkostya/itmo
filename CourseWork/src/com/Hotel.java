package com;

public class Hotel {

	public String name;
	public String rank;
	public String rooms;
	public String street;
	public String house;
	public String telephone;
	public String website;

	public Hotel(String name, String rank, String rooms, String street, String house,
			String telephone, String website) {
		this.name = name;
		this.rank = rank;
		this.rooms = rooms;
		this.street = street;
		this.house = house;
		this.telephone = telephone;
		this.website = website;
	}

	public String getName() {
		return this.name;
	}

	public String getRank() {
		return this.rank;
	}
	
	public String getRooms() {
		return this.rooms;
	}

	public String getStreet() {
		return this.street;
	}

	public String getHouse() {
		return this.house;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public String getWebsite() {
		return this.website;
	}

}
