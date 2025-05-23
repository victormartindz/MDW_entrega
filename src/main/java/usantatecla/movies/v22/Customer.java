package usantatecla.movies.v22;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String name;

	private List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		rentals = new ArrayList<Rental>();
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		String result = "Rental Record for " + this.getName() + "\n";
		for (Rental each : rentals) {
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
		}
		result += "Amount owed is " + String.valueOf(this.getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(this.getTotalFrequentRenterPoints()) + " frequent renter points";
		return result;
	}

	private double getTotalCharge() {
		double result = 0;
		for (Rental each : this.rentals) {
			result += each.getCharge();
		}
		return result;
	}

	private int getTotalFrequentRenterPoints() {
		int result = 0;
		for (Rental each : this.rentals) {
			result += each.getFrequentRenterPoints();
		}
		return result;
	}

}
