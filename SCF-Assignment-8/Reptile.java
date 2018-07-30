package Question1;

/**
 * Reptile contains properties of reptile and extends Animal class.
 * 
 * @author Arjita
 *
 */
public class Reptile extends Animal {
	int legs;

	public Reptile(String name, int age, String sound) {
		super(name, age, sound);
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}

	public int getLegs() {
		return legs;
	}
}