package com.bridgelabz.hotelreservation;

public class Hotel {
	private String hotelName;
	private int weekDayRate;
	private int weekendRate;
	private int weekDayRateForReward;
	private int weekendRateForReward;
	private long totalRate;
	private double rating;

	public Hotel(String hotelName, int weekDayRate, int weekendRate, int weekDayRateForReward, int weekendRateForReward,
			double rating) {
		super();
		this.hotelName = hotelName;
		this.weekDayRate = weekDayRate;
		this.weekendRate = weekendRate;
		this.weekDayRateForReward = weekDayRateForReward;
		this.weekendRateForReward = weekendRateForReward;
		this.rating = rating;
	}

	public long getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(long totalRate) {
		this.totalRate = totalRate;
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

	public int getWeekDayRateForReward() {
		return weekDayRateForReward;
	}

	public void setWeekDayRateForReward(int weekDayRateForReward) {
		this.weekDayRateForReward = weekDayRateForReward;
	}

	public int getWeekendRateForReward() {
		return weekendRateForReward;
	}

	public void setWeekendRateForReward(int weekendRateForReward) {
		this.weekendRateForReward = weekendRateForReward;
	}

	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", weekDayRate=" + weekDayRate + ", weekendRate=" + weekendRate
				+ ", weekDayRateForReward=" + weekDayRateForReward + ", weekendRateForReward=" + weekendRateForReward
				+ ", totalRate=" + totalRate + ", rating=" + rating + "]";
	}

}
