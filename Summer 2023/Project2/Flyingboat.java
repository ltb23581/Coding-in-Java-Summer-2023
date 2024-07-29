
public class Flyingboat extends Vehicle implements Flyable, Floatable {

	// Flyingboats own methods
	private int numberOfEngines;
	private String shippingLineOwner;

	public int getNumberOfEngines() {
		return numberOfEngines;
	}

	public void setNumberOfEngines(int n) {
		this.numberOfEngines = n;
	}

	public String getShippingLineOwner() {
		return shippingLineOwner;
	}

	public void setShippingLineOwner(String s) {
		this.shippingLineOwner = s;
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

	// implements Floatable methods
	private int tonnage;

	@Override
	public int getTonnage() {
		return tonnage;
	}

	@Override
	public void setTonnage(int tonnage) {
		this.tonnage = tonnage;
	}

	// toString method prints out data for Automobiles
	@Override
	public String toString() {
		return "Type: Flyingboat\nName: " + getName() + "\nManufacturer: " + getManufacture() + "\nManufacture year: "
				+ getYearOfManufacture() + "\nNumber of engines: " + getNumberOfEngines() + "\nMax altitude: "
				+ getMaxAltitude() + " ft\nMax range: " + getMaxRange() + " mi\nTonnage: " + getTonnage() + "\nOwner: "
				+ getShippingLineOwner() + "\nMax passengers: " + getMaxPassengers() + "\nTop speed: " + getTopSpeed()
				+ " mph";
	}

}
