public class Ship extends Vehicle implements Floatable {

	// Ships own methods
	private String shippingLineOwner;

	public String getShippingLineOwner() {
		return shippingLineOwner;
	}

	public void setShippingLineOwner(String s) {
		this.shippingLineOwner = s;
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
		return "Type: Ship\nName: " + getName() + "\nManufacturer: " + getManufacture() + "\nManufacture year: "
				+ getYearOfManufacture() + "\nTonnage: " + getTonnage() + "\nOwner: " + getShippingLineOwner()
				+ "\nMax passengers: " + getMaxPassengers() + "\nTop speed: " + getTopSpeed() + " mph";
	}

}
