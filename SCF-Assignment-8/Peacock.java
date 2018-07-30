package Question1;

/**
 * Peacock class contains peacock properties and extends Bird class.
 * 
 * @author Arjita
 *
 */
public class Peacock extends Bird {

	public Peacock(String name, int age, String sound, int flight) {
		super(name, age, sound);
		setFlightInMeters(flight);
	}

	public String getInfo() {
		return "\nName : " + getName() + "\nAge : " + getAge()
				+ "\nCategory : " + getCategory() + "\nType : " + getType()
				+ "\nSound : " + getSound() + "\nFlight in meters : "
				+ getFlightInMeters();
	}

}
