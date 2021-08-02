package com.critiflix.app.models;

public class TheaterLocation {
	private String name;
	private String lat;
	private String lng;
	private String place_id;
	private String vicinity;
	
	public TheaterLocation() {
		
	}

	public TheaterLocation(String name, String lat, String lng, String place_id, String vicinity) {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXX" + name);
		this.name = name;
		this.lat = lat;
		this.lng = lng;
		this.place_id = place_id;
		this.vicinity = vicinity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getPlace_id() {
		return place_id;
	}

	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}

	public String getVicinity() {
		return vicinity;
	}

	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}

}
