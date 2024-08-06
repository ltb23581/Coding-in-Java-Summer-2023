public interface Transporter {

	// Methods required of all transporters
	int getMaxPassengers();

	void setMaxPassengers(int maxPassengers);

	int getTopSpeed();

	void setTopSpeed(int topSpeed);

}
