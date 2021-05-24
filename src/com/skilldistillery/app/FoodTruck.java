package com.skilldistillery.app;

public class FoodTruck {
	//fields
	private static int truckNumber = 001;
	private String truckName;
	private String foodType;
	private int rating;
	private int truckID;
	
	
	//constructors
	public FoodTruck() {

	}

	public FoodTruck(String truckName, String foodType, int rating) {
		this(truckName, foodType, rating, truckNumber);

	}

	public FoodTruck(String truckName, String foodType, int rating, int truckId) {
		this.truckID = truckId;
		this.truckName = truckName;
		this.foodType = foodType;
		this.rating = rating;
	}
	
	
	//getter and setter methods
	public int getTruckID() {
		return truckID;
	}

	public void setTruckID(int truckID) {
		this.truckID = truckID;
	}

	public void setTRUCK_ID() {
		truckNumber++;

	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	//string builder
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Food Truck# ").append(truckID).append("\t Truck Name: ").append(truckName)
				.append("\t Food Type: ").append(foodType).append("\t Truck Rating: ").append(rating);
		return builder.toString();
	}

}
