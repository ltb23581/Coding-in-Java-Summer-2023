abstract class Vehicle implements Transporter {

	/*
	 * Creates variables to contain all the things required of a Vehicle.
	 */
	private static int count = 0;
	private String name;
	private String manufacture;
	private int yearOfManufacture;

	/*
	 * When an instance of a Vehicle is created a count is incremented
	 */
	public Vehicle() {
		count++;
	}

	public int getCount() {
		return count;
	}

	// Creates the variables getters and setters
	public void setName(String n) {
		this.name = n;
	}

	public String getName() {
		return name;
	}

	public void setManufacture(String m) {
		this.manufacture = m;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setYearOfManufacture(int y) {
		this.yearOfManufacture = y;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	// implements Transporter methods
	private int maxPassengers;
	private int topSpeed;

	@Override
	public int getMaxPassengers() {
		return maxPassengers;
	}

	@Override
	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}

	@Override
	public int getTopSpeed() {
		return topSpeed;
	}

	@Override
	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}
}
