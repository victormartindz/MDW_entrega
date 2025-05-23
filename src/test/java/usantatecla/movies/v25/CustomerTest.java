package usantatecla.movies.v25;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void amountWithoutRentalsTest() {
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).build();

		double expectedAmount = 0;
		double actualAmount = customer.getTotalCharge();
		assertEquals(expectedAmount, actualAmount, 0.001);
	}

	@Test
	public void frequentRenterPointsWithoutRentalsTest() {
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).build();

		int expectedFrequentRenterPoints = 0;
		int actualFrequentRenterPoints = customer.getTotalFrequentRenterPoints();
		assertEquals(expectedFrequentRenterPoints, actualFrequentRenterPoints);
	}

	@Test
	public void statementWithoutRentalsTest() {
		String customerName = "customerName";
		String expectedStatement = new StatementBuilder()
				.customerName(customerName)
				.build();
		Customer customer = new CustomerBuilder().name(customerName).build();
		String actualStatement = customer.statement();
		assertEquals(expectedStatement, actualStatement);
	}

	@Test
	public void amountRegularRental1DayTest() {
		double expectedAmount = 2.0;
		Rental rental = prepareRegularRental(1);
		Customer customer = prepareCustomer(rental);

		double actualAmount = customer.getTotalCharge();
		assertEquals(expectedAmount, actualAmount, 0.001);
	}

	@Test
	public void frequentRenterPointsRegularRental1DayTest() {
		int expectedFrequentRenterPoints = 1;
		Rental rental = prepareRegularRental(1);
		Customer customer = prepareCustomer(rental);
		int actualFrequentRenterPoints = customer.getTotalFrequentRenterPoints();
		assertEquals(expectedFrequentRenterPoints, actualFrequentRenterPoints);
	}

	@Test
	public void amountRegularRental2DayTest() {
		double expectedAmount = 2.0;
		Rental rental = prepareRegularRental(2);
		Customer customer = prepareCustomer(rental);
		double actualAmount = customer.getTotalCharge();
		assertEquals(expectedAmount, actualAmount, 0.001);
	}

	@Test
	public void frequentRenterPointsRegularRental2DayTest() {
		int expectedFrequentRenterPoints = 1;
		Rental rental = prepareRegularRental(2);
		Customer customer = prepareCustomer(rental);
		int actualFrequentRenterPoints = customer.getTotalFrequentRenterPoints();
		assertEquals(expectedFrequentRenterPoints, actualFrequentRenterPoints);
	}

	@Test
	public void regularRental2DayTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).regular().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
		String customerName = "customerName";
		Customer customer = prepareCustomer(rental);

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 2)
				.totalAmount(2).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}

	@Test
	public void amountRegularRental3DayTest() {
		double expectedAmount = 3.5;
		Rental rental = prepareRegularRental(3);
		Customer customer = prepareCustomer(rental);
		double actualAmount = customer.getTotalCharge();
		assertEquals(expectedAmount, actualAmount, 0.001);
	}

	@Test
	public void frequentRenterPointsRegularRental3DayTest() {
		int expectedFrequentRenterPoints = 1;
		Rental rental = prepareRegularRental(3);
		Customer customer = prepareCustomer(rental);
		int actualFrequentRenterPoints = customer.getTotalFrequentRenterPoints();
		assertEquals(expectedFrequentRenterPoints, actualFrequentRenterPoints);
	}

	@Test
	public void amountNewReleaseRental1DayTest() {
		Rental rental = prepareNewReleaseRental( 1);
		Customer customer = prepareCustomer(rental);
		double expectedAmount = 3.0;
		double actualAmount = customer.getTotalCharge();
		assertEquals(expectedAmount, actualAmount, 0.001);
	}

	@Test
	public void frequentRenterPointsNewReleaseRental1DayTest() {
		Rental rental = prepareNewReleaseRental( 1);
		Customer customer = prepareCustomer(rental);
		int expectedFrequentRenterPoints = 1;
		int actualFrequentRenterPoints = customer.getTotalFrequentRenterPoints();
		assertEquals(expectedFrequentRenterPoints, actualFrequentRenterPoints);
	}

	@Test
	public void amountNewRelease2DayTest() {
		Rental rental = prepareNewReleaseRental(2);
		Customer customer = prepareCustomer(rental);
		double expectedAmount = 3.0;
		double actualAmount = customer.getTotalCharge();
		assertEquals(expectedAmount, actualAmount, 0.001);
	}

	@Test
	public void frequentRenterPointsNewReleaseRental2DayTest() {
		Rental rental = prepareNewReleaseRental(2);
		Customer customer = prepareCustomer(rental);
		int expectedFrequentRenterPoints = 2;
		int actualFrequentRenterPoints = customer.getTotalFrequentRenterPoints();
		assertEquals(expectedFrequentRenterPoints, actualFrequentRenterPoints);
	}

	@Test
	public void newReleaseRental2DayTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).newRelease().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
		String customerName = "customerName";
		Customer customer = prepareCustomer(rental);

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
				.totalAmount(3).frequentRenterPoints(2).build();
		assertEquals(result, statement);
	}

	@Test
	public void amountNewReleaseRental3DayTest() {
		Rental rental = prepareNewReleaseRental(3);
		Customer customer = prepareCustomer(rental);
		double actualAmount = customer.getTotalCharge();
		double expectedAmount = 3.0;
		assertEquals(expectedAmount, actualAmount, 0.001);
	}

	@Test
	public void frequentRenterPointsNewReleaseRental3DayTest() {
		Rental rental = prepareNewReleaseRental(3);
		Customer customer = prepareCustomer(rental);
		int expectedFrequentRenterPoints = 2;
		int actualFrequentRenterPoints = customer.getTotalFrequentRenterPoints();
		assertEquals(expectedFrequentRenterPoints, actualFrequentRenterPoints);
	}

	@Test
	public void amountChildrensRental1DayTest() {
		Rental rental = prepareChildrensMovieRental(1);
		Customer customer = prepareCustomer(rental);
		double expectedAmount = 1.5;
		double actualAmount = customer.getTotalCharge();
		assertEquals(expectedAmount, actualAmount, 0.001);
	}

	@Test
	public void frequentRenterPointsChildrensRental1DayTest() {
		Rental rental = prepareChildrensMovieRental(1);
		Customer customer = prepareCustomer(rental);
		int expectedFrequentRenterPoints = 1;
		int actualFrequentRenterPoints = customer.getTotalFrequentRenterPoints();
		assertEquals(expectedFrequentRenterPoints, actualFrequentRenterPoints);
	}

	@Test
	public void amountChildrensRental3DayTest() {
		Rental rental = prepareChildrensMovieRental(3);
		Customer customer = prepareCustomer(rental);
		double expectedAmount = 1.5;
		double actualAmount = customer.getTotalCharge();
		assertEquals(expectedAmount, actualAmount, 0.001);
	}

	@Test
	public void frequentRenterPointsChildrensRental3DayTest() {
		Rental rental = prepareChildrensMovieRental(3);
		Customer customer = prepareCustomer(rental);
		int expectedFrequentRenterPoints = 1;
		int actualFrequentRenterPoints = customer.getTotalFrequentRenterPoints();
		assertEquals(expectedFrequentRenterPoints, actualFrequentRenterPoints);
	}

	@Test
	public void amountChildrensRental4DayTest() {
		Rental rental = prepareChildrensMovieRental(4);
		Customer customer = prepareCustomer(rental);
		double expectedAmount = 6.0;
		double actualAmount = customer.getTotalCharge();
		assertEquals(expectedAmount, actualAmount, 0.001);
	}

	@Test
	public void childrensRental4DayTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).childrens().build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(4).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 6)
				.totalAmount(6).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}

	@Test
	public void frequentRenterPointsChildrensRental4DayTest() {
		Rental rental = prepareChildrensMovieRental(4);
		Customer customer = prepareCustomer(rental);
		int expectedFrequentRenterPoints = 1;
		int actualFrequentRenterPoints = customer.getTotalFrequentRenterPoints();
		assertEquals(expectedFrequentRenterPoints, actualFrequentRenterPoints);
	}

	@Test
	public void rentalTest() {
		String regularMovieName = "regularMovieName";
		Movie regularMovie = new MovieBuilder().title(regularMovieName).regular().build();
		Rental regularRental = new RentalBuilder().movie(regularMovie).daysRented(10).build();

		String newReleaseMovieName = "newReleaseMovieName";
		Movie newReleaseMovie = new MovieBuilder().title(newReleaseMovieName).newRelease().build();
		Rental newReleaseRental = new RentalBuilder().movie(newReleaseMovie).daysRented(10).build();

		String childrensMovieName = "childrensMovieName";
		Movie childrensMovie = new MovieBuilder().title(childrensMovieName).childrens().build();
		Rental childrensRental = new RentalBuilder().movie(childrensMovie).daysRented(10).build();

		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName)
				.rental(regularRental).rental(newReleaseRental).rental(childrensRental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName)
				.movie(regularMovieName, 14).movie(newReleaseMovieName, 3).movie(childrensMovieName, 15)
				.totalAmount(32).frequentRenterPoints(4).build();
		assertEquals(result, statement);
	}

	private static Rental prepareRegularRental(Integer daysRented) {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).regular().build();
		return new RentalBuilder().movie(movie).daysRented(daysRented).build();
	}


	private static Rental prepareNewReleaseRental(int daysRented) {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).newRelease().build();
		return new RentalBuilder().movie(movie).daysRented(daysRented).build();
	}

	private Customer prepareCustomer(Rental rental) {
		String customerName = "customerName";
		return new CustomerBuilder().name(customerName).rental(rental).build();
	}

	private static Rental prepareChildrensMovieRental(int daysRented) {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).childrens().build();
		return new RentalBuilder().movie(movie).daysRented(daysRented).build();
	}
}
