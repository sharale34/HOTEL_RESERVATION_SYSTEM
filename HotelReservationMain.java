package com.bridgelabz.hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

public class HotelReservationMain {

	static HotelReservation hotelObj = new HotelReservation();

	// Adding hotel details
	public static void addHotelForRegularCustomer() {
		Hotel lakeWood = new Hotel("LakeWood", 110, 90);
		Hotel bridgeWood = new Hotel("BridgeWood", 160, 60);
		Hotel ridgeWood = new Hotel("RidgeWood", 220, 150);
		hotelObj.addHotelToList(lakeWood);
		hotelObj.addHotelToList(bridgeWood);
		hotelObj.addHotelToList(ridgeWood);
		hotelObj.getHotelList().stream().forEach((hotelList) -> System.out.println(hotelList));
	}
    //finding cheapest hotel for a given date range
	public static Hotel findCheapestHotel(String start, String end) throws ParseException {
		Date startDate = null, endDate = null;
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMMyyyy");
		startDate = formatter.parse(start);
		endDate = formatter.parse(end);
		long dateRange = 1 + (endDate.getTime() - startDate.getTime()) / 1000 / 60 / 60 / 24;
		Hotel cheapestHotel = hotelObj.getHotelList().stream().sorted(Comparator.comparing(Hotel::getWeekDayRate))
				.findFirst().orElse(null);
		long totalRate = dateRange * cheapestHotel.getWeekDayRate();
		cheapestHotel.setTotalRate(totalRate);
		return cheapestHotel;
	} 

	public static void main(String[] args) {
		System.out.println("Welcome to the Hotel Reservation System");
		addHotelForRegularCustomer();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the check in date in ddMMMYYYY format");
		String startDate = sc.next();
		System.out.println("Enter the check out date in ddMMMYYYY format");
		String endDate = sc.next();
		Hotel cheapestHotel = null;
		try {
			cheapestHotel = findCheapestHotel(startDate, endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Cheapest hotel is "+ cheapestHotel.getHotelName() + " whose total rate is $ " + cheapestHotel.getTotalRate());
	}
}
