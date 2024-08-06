public class Airplane extends Vehicle implements Flyable {

	// Airplanes own methods
	private int numberOfEngines;

	public int getNumberOfEngines() {
		return numberOfEngines;
	}

	public void setNumberOfEngines(int n) {
		this.numberOfEngines = n;
	}

	// implements Flyable methods
	private int maxAltitude;
	private int maxRange;

	@Override
	public int getMaxAltitude() {
		return maxAltitude;
	}

	@Override
	public void setMaxAltitude(int maxAltitude) {
		this.maxAltitude = maxAltitude;
	}

	@Override
	public int getMaxRange() {
		return maxRange;
	}

	@Override
	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}

	// toString method prints out data for Automobiles
	@Override
	public String toString() {
		return "Type: Airplane\nName: " + getName() + "\nManufacturer: " + getManufacture() + "\nManufacture year: "
				+ getYearOfManufacture() + "\nNumber of engines: " + getNumberOfEngines() + "\nMax altitude: "
				+ getMaxAltitude() + " ft\nMax range: " + getMaxRange()
				+ " mi\nMax passengers: "
				+ getMaxPassengers() + "\nTop speed: " + getTopSpeed() + " mph";
	}

}
