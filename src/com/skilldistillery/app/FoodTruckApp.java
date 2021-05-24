package com.skilldistillery.app;

import java.util.Scanner;

public class FoodTruckApp {

	//Setting the max number of trucks to be entered by user at 5
	//trucks will go into an array with a predetermined size
	private static final int MAX_TRUCKS = 5;
	FoodTruck[] trucks = new FoodTruck[MAX_TRUCKS];
	private int count = 0;

	public static void main(String[] args) {
		FoodTruckApp foodTruck = new FoodTruckApp();
		System.out.println("-----------------------------------\n"+"Welcome to the Food Truck App!\n" + 
		"-----------------------------------");
		foodTruck.run();
	}
//                     methods

	private void run() {
		Scanner kb = new Scanner(System.in);
		String selection;

		do {
			displayMainMenu();
			selection = kb.nextLine();

			switch (selection) {
			case "1":
				if (count == trucks.length) {
					System.out.println("Can not hold any more trucks. "
							+ "Press and enter any key to return to main menu: ");
					kb.nextLine();
					break;
				} else {
					newTruck(kb);
					break;
				}
			case "2":
				displayTrucks();
				System.out.print("\nPress and enter any key to return to main menu: ");
				kb.nextLine();
				System.out.println("");
				break;
			case "3":
				displayAverage();
				System.out.print("\nPress and enter any key to return to main menu: ");
				kb.nextLine();
				break;
			case "4":
				displayHighestRated();
				System.out.print("\nPress and enter any key to return to main menu: ");
				kb.nextLine();
				break;
			case "5":
				System.out.println("Thanks for using the Food Truck App! "
						+ "Leave us a rating on the Apple Store:)");
				break;
			default:
				System.out.print("\nYour action did not register."
						+ " Press and enter any key to return to main menu: ");
				kb.nextLine();
			}
		} while (!selection.equals("5"));

		kb.close();
	} 

	private void displayMainMenu() {
		System.out.print(
				"\n*Please press and enter a number*\n\n1. Add A New Food Truck\n2. Show All Food Trucks\n3."
				+ " Show Average Rating for All Food Trucks\n4. Show Highest Rated Food Truck(s)\n5. "
				+ "Exit App\n--->");
	}

	private void displaySecondMenu() {
		System.out.print("\n1. Add another truck\n2. Return to main menu\n--->");
	}

	private void newTruck(Scanner kb) {
		int selection2;
		String name;
		String foodType;
		int rating;
		do {
			System.out.println("Enter name of food truck, or enter 'e' to return to the main menu: ");
			name = kb.nextLine();
			if (checkForEnd(name)) {
				break;
			}

			System.out.println("What type of food does " + name + " serve?: ");
			foodType = kb.nextLine();

			System.out.print("What would you rate " + name + " on a scale of 1-10?: ");
			rating = kb.nextInt();
			kb.nextLine();

			FoodTruck newTruck = new FoodTruck(name, foodType, rating);
			addTruck(newTruck);
			newTruck.setTRUCK_ID();

			if (count < trucks.length) {
				displaySecondMenu();
				selection2 = kb.nextInt();
				kb.nextLine();
				switch (selection2) {
				case 1:
					continue;
				case 2:
					break;
				}
			} else {
				System.out.print("You have exceded the truck capacity. "
						+ "Enter any key to return to main menu: ");
				kb.nextLine();
				break;
			}
		} while (selection2 == 1); 
	} 

	private void addTruck(FoodTruck truck) {
		trucks[count] = truck;
		count++;
	}

	private void displayTrucks() {
		System.out.println("");
		for (FoodTruck truck : trucks) {
			if (truck != null) {
				System.out.println(truck.toString());
			}

		}
	}

	private void displayAverage() {
		double totalRatings = 0.0;
		double averageRating = 0.0;
		for (FoodTruck truck : trucks) {
			if (truck != null) {
				totalRatings += truck.getRating();
			}
		}
		averageRating = (totalRatings) / (count);
		System.out.println("Average rating for all food trucks is " + averageRating);

	}

	private void displayHighestRated() {
		int highest = 0;
		for (FoodTruck truck : trucks) {
			if (truck != null) {
				if (truck.getRating() > highest) {
					highest = truck.getRating();
				}
			}
		}
		for (FoodTruck truck : trucks) {
			if (truck != null) {
				if (truck.getRating() == highest) {
					System.out.println(truck.toString());
				}
			}
		}
	}

	boolean checkForEnd(String name) {
		boolean result = false;
		switch (name) {
		case "e":
			result = true;
			break;
		case "E":
			result = true;
			break;
		case "end":
			result = true;
			break;
		case "End":
			result = true;
			break;
		case "END":
			result = true;
			break;
		}

		return result;
	}
}
