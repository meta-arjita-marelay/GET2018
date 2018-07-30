package Question1;

/**
 * Crocodile contains properties of crocodile and extends Reptile.
 * 
 * @author Arjita
 *
 */
public class Crocodile extends Reptile {

	public Crocodile(String name, int age, String sound, int legs) {
		super(name, age, sound);
		setLegs(legs);
	}

	public String getInfo() {
		return "\nName : " + getName() + "\nAge : " + getAge()
				+ "\nCategory : " + getCategory() + "\nType : " + getType()
				+ "\nSound : " + getSound() + "\nNo of Legs : " + getLegs();
	}

	/*
	 * public static void main(String[] args) { Crocodile c = new
	 * Crocodile("titar", 5, "hurr hurr", 4); System.out.println(c.getInfo()); }
	 */
}
