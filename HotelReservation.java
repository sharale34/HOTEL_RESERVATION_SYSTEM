package com.bridgelabz.hotelreservation;

import java.util.ArrayList;

public class HotelReservation {

	private ArrayList<Hotel> hotelList = new ArrayList<>();

	public ArrayList<Hotel> getHotelList() {
		return hotelList;
	}

	public void setHotelList(ArrayList<Hotel> hotelList) {
		this.hotelList = hotelList;
	}

	public void addHotelToList(Hotel hotel) {
		hotelList.add(hotel);
	}
}
