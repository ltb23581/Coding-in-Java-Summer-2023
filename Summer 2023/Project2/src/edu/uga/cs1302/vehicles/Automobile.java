public class Automobile extends Vehicle {

	// Automobiles own methods
	private int horsepower;

	public int getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(int h) {
		this.horsepower = h;
	}

	// toString method prints out data for Automobiles
	@Override
	public String toString() {
		return "Type: Automobile\nName: " + getName() + "\nManufacturer: " + getManufacture() + "\nManufacture year: "
				+ getYearOfManufacture() + "\nEngine power: " + getHorsepower() + " hp\nMax passengers: "
				+ getMaxPassengers() + "\nTop speed: " + getTopSpeed() + " mph";
	}
}
