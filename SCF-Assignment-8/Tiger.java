package Question1;

/**
 * Tiger contains properties of tiger, and extends properties of mammal.
 * 
 * @author Arjita
 *
 */
public class Tiger extends Mammal {

	public Tiger(String name, int age, String sound) {
		super(name, age, sound);
	}

	public String getInfo() {
		return "\nName : " + getName() + "\nAge : " + getAge()
				+ "\nCategory : " + getCategory() + "\nType : " + getType()
				+ "\nSound : " + getSound();
	}
}
