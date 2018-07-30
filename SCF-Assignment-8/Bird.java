package Question1;

/**
 * Bird is subclass of Animal.
 * 
 * @author Arjita
 *
 */
public class Bird extends Animal {
	public Bird(String name, int age, String sound) {
		super(name, age, sound);
	}

	private int flightInMeters;// flight distance by bird in meters

	public void setFlightInMeters(int flight) {
		this.flightInMeters = flight;
	}

	public int getFlightInMeters() {
		return flightInMeters;
	}
}
