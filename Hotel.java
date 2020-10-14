package com.bridgelabz.hotelreservation;

public class Hotel {
	private String hotelName;
	private int weekDayRate;
	private int weekendRate;
	private long totalRate;
	private double rating;

	public long getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(long totalRate) {
		this.totalRate = totalRate;
	}

	public Hotel(String hotelName, int weekDayRate, int weekendRate, double rating) {
		super();
		this.hotelName = hotelName;
		this.weekDayRate = weekDayRate;
		this.weekendRate = weekendRate;
		this.rating = rating;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getWeekDayRate() {
		return weekDayRate;
	}

	public void setWeekDayRate(int weekDayRate) {
		this.weekDayRate = weekDayRate;
	}

	public int getWeekendRate() {
		return weekendRate;
	}

	public void setWeekendRate(int weekendRate) {
		this.weekendRate = weekendRate;
	}

	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", weekDayRate=" + weekDayRate + ", weekendRate=" + weekendRate
				+ ", totalRate=" + totalRate + ", rating=" + rating + "]";
	}
}
