package usantatecla.movies.v24;

public class NewReleasedMovie {
    private static final int DAYS_RENTED_THRESHOLD = 1;
    private static final int FREQUENT_RENTER_POINTS = 2;
    private static final double CHARGE = 3.0;

    @Override
    public double getCharge(int daysRented) {
        return NewReleasedMovie.CHARGE;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        if (daysRented > NewReleasedMovie.DAYS_RENTED_THRESHOLD) {
            return NewReleasedMovie.FREQUENT_RENTER_POINTS;
        } else {
            return super.getFrequentRenterPoints(daysRented);
        }
    }
}

