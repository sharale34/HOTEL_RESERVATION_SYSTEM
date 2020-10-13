package com.bridgelabz.hotelreservation;

public class HotelReservationMain {

	public static void addHotelForRegularCustomer() {
		Hotel lakeWood = new Hotel("LakeWood", 110, 90);
		Hotel bridgeWood = new Hotel("BridgeWood", 160, 60);
		Hotel ridgeWood = new Hotel("RidgeWood", 220, 150);
		HotelReservation hotelObj = new HotelReservation();
		hotelObj.addHotelToList(lakeWood);
		hotelObj.addHotelToList(bridgeWood);
		hotelObj.addHotelToList(ridgeWood);
		hotelObj.getHotelList().stream().forEach((hotelList) -> System.out.println(hotelList));
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Hotel Reservation System");
		addHotelForRegularCustomer();
	}
}
