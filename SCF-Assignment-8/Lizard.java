package Question1;

/**
 * Lizard contains properties of lizard and extends reptile.
 * 
 * @author Arjita
 *
 */
public class Lizard extends Reptile {

	public Lizard(String name, int age, String sound, int legs) {
		super(name, age, sound);
		setLegs(legs);
	}

	public String getInfo() {
		return "\nName : " + getName() + "\nAge : " + getAge()
				+ "\nCategory : " + getCategory() + "\nType : " + getType()
				+ "\nSound : " + getSound() + "\nNo of Legs : " + getLegs();
	}

	/*
	 * public static void main(String[] args) { Lizard c = new
	 * Lizard("lizardName", 2, "ssssssss", 4); System.out.println(c.getInfo());
	 * }
	 */
}
