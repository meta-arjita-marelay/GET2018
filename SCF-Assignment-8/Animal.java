package Question1;

/**
 * Animal specifies the properties of animal and have subclasses as mammal,bird
 * and reptile.
 * 
 * @author Arjita
 *
 */

public class Animal {
	private String name, sound;// name and type of sound of animal
	private int age;// age of animal
	private TypeOfAnimal type;// type of animal can be selected by TypeofAnimal
								// enum
	private Category category;// category can be selected by Category enum

	/**
	 * Constructor to initialise the private members
	 * 
	 * @param name
	 *            animal name
	 * @param age
	 *            animal age
	 * @param sound
	 *            animal sound
	 */
	public Animal(String name, int age, String sound) {
		this.name = name;
		this.sound = sound;
		setAge(age);

		switch (this.getClass().getSuperclass().getSimpleName()) {
		case "Mammal":
			category = Category.Mammal;
			break;

		case "Bird":
			category = Category.Bird;
			break;

		case "Reptile":
			category = Category.Reptile;
			break;

		default:
			throw new AssertionError("No such animal category exists!");
		}

		switch (this.getClass().getSimpleName()) {
		case "Tiger":
			type = TypeOfAnimal.Tiger;
			break;
		case "Peacock":
			type = TypeOfAnimal.Peacock;
			break;
		case "Crocodile":
			type = TypeOfAnimal.Crocodile;
			break;
		default:
			throw new AssertionError("No such animal exists!");
		}
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public Category getCategory() {
		return category;
	}

	public TypeOfAnimal getType() {
		return type;
	}

	public String getSound() {
		return sound;
	}

	public int getAge() {
		return age;
	}

	public String getInfo() {
		return "null";
	}

}
