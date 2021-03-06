package com.bridgelabz.hotelreservation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HotelReservationMain {

	static HotelReservation hotelObj = new HotelReservation();

	// Adding hotel details
	public static void addHotelForRegularCustomer() {
		Hotel lakeWood = new Hotel("LakeWood", 110, 90, 80, 80, 3);
		Hotel bridgeWood = new Hotel("BridgeWood", 150, 50, 110, 50, 4);
		Hotel ridgeWood = new Hotel("RidgeWood", 220, 150, 100, 40, 5);
		hotelObj.addHotelToList(lakeWood);
		hotelObj.addHotelToList(bridgeWood);
		hotelObj.addHotelToList(ridgeWood);
		hotelObj.getHotelList().stream().forEach((hotelList) -> System.out.println(hotelList));
	}

	// finding cheapest hotel for a given date range
	public static Hotel findCheapestHotel(String start, String end, String type) throws ParseException {
		Date startDate = null, endDate = null;
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMMyyyy");
		startDate = formatter.parse(start);
		endDate = formatter.parse(end);
		long dateRange = 1 + (endDate.getTime() - startDate.getTime()) / 1000 / 60 / 60 / 24;
		DateFormat day = new SimpleDateFormat("EE");
		String startDay = day.format(startDate);
		String endDay = day.format(endDate);
		long weekends = 0;
		if (startDay.equalsIgnoreCase("sat") || startDay.equalsIgnoreCase("sun")) {
			weekends++;
		}
		if (endDay.equalsIgnoreCase("sat") || endDay.equalsIgnoreCase("sun")) {
			weekends++;
		}
		Long weekdays = dateRange - weekends;
		for (Hotel hotel : hotelObj.getHotelList()) {
			if (type.toLowerCase()=="regular") {
				Long totalRate = weekdays * hotel.getWeekDayRate() + weekends * hotel.getWeekendRate();
				hotel.setTotalRate(totalRate);
			}
			else {
				Long totalRate = weekdays * hotel.getWeekDayRateForReward() + weekends * hotel.getWeekendRateForReward();
				hotel.setTotalRate(totalRate);
			}
		}
		List<Hotel> sortedHotelListOnRating = hotelObj.getHotelList().stream()
				.sorted(Comparator.comparing(Hotel::getRating)).collect(Collectors.toList());
		Hotel bestRatedHotel = sortedHotelListOnRating.get(2);
		System.out.println("Best Rated hotel is " + bestRatedHotel.getHotelName() + ", Rating "
				+ bestRatedHotel.getRating() + " with total rate $ " + bestRatedHotel.getTotalRate());
		List<Hotel> sortedHotelListOnRate = hotelObj.getHotelList().stream()
				.sorted(Comparator.comparing(Hotel::getTotalRate)).collect(Collectors.toList());
		Hotel cheapestHotel = sortedHotelListOnRate.get(0);
		long lowestPrice = sortedHotelListOnRate.get(0).getTotalRate();
		double rating = sortedHotelListOnRate.get(0).getRating();
		for (Hotel hotel : hotelObj.getHotelList()) {
			if (hotel.getTotalRate() <= lowestPrice && hotel.getRating() > rating)
				cheapestHotel = hotel;
			else
				break;
		}
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
		System.out.println("Enter the type of customer :");
		String type = sc.next();
		Hotel cheapestHotel = null;
		try {
			cheapestHotel = findCheapestHotel(startDate, endDate, type);
			System.out.println("Cheapest best rated hotel for "+type+" customer is " + cheapestHotel.getHotelName() + ", Rating "
					+ cheapestHotel.getRating() + " with total rate $ " + cheapestHotel.getTotalRate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
