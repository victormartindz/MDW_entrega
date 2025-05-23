package usantatecla.movies.v24;

public class Movie {
	private static final int FREQUENT_RENTER_POINTS = 1;
	private static final int DAYS_RENTED_THRESHOLD = 2;
	private static final double CHARGE = 2.0;
	private static final double EXTRA_CHARGE = 1.5;

	private String title;

	public Movie(String title) {
		this.title = title;
	}

	public double getCharge(int daysRented) {
		double result = Movie.CHARGE;
		if (daysRented > Movie.DAYS_RENTED_THRESHOLD) {
			result += (daysRented - Movie.DAYS_RENTED_THRESHOLD) * Movie.EXTRA_CHARGE;
		}
		return result;
	}

	public int getFrequentRenterPoints(int daysRented) {
		return FREQUENT_RENTER_POINTS;
	}

	public String getTitle() {
		return title;
	}

}
