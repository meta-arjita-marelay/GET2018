package Question1;

import java.util.ArrayList;
import java.util.List;

/**
 * Cage class will contain different properties of cage.
 * 
 * @author Arjita
 *
 */

public class Cage {
	private int capacity;
	private TypeOfAnimal typeOfAnimal;
	private Category categoryOfZone;
	private List<Animal> listOfAnimals = new ArrayList<Animal>();

	/**
	 * Constructor to initialise the private member
	 * 
	 * @param capacity
	 *            cage capacity
	 * @param category
	 *            cage category
	 * @param animalType
	 *            type of animal
	 */
	public Cage(int capacity, Category category, TypeOfAnimal animalType) {
		this.capacity = capacity;
		this.categoryOfZone = category;
		switch (animalType) {
		case Crocodile:
			this.typeOfAnimal = TypeOfAnimal.Crocodile;
			break;
		case Tiger:
			this.typeOfAnimal = TypeOfAnimal.Tiger;
			break;
		case Peacock:
			this.typeOfAnimal = TypeOfAnimal.Peacock;
			break;
		default:
			break;
		}
	}

	public int getCapacity() {
		return capacity;
	}

	public Category getCategoryOfZone() {
		return categoryOfZone;
	}

	public TypeOfAnimal getTypeOfAnimal() {
		return typeOfAnimal;
	}

	public boolean addAnimal(Animal animal, int zone, int i) {
		if (typeOfAnimal == animal.getType()) {
			if (listOfAnimals.size() < capacity) {
				listOfAnimals.add(animal);
				System.out
						.println("Animal added successfully, Details are below :\nZone : "
								+ (zone + 1) + "\nCage : " + (i + 1));
				return true;
			} else {
				System.out
						.println("Cage has reached it's limit. Can not add animal.");
				return false;
			}

		} else {
			System.out
					.println("Can not add the animal to this category of cage.");
			return false;
		}
	}

	public String getInfo() {
		String animals = "";
		for (Animal animal : listOfAnimals) {
			int index = 1;
			animals = "\n" + index + ". " + animal.getType();
		}
		return "\nType of animal contained : " + getTypeOfAnimal()
				+ "\nCapacity of the cage : " + getCapacity()
				+ "\nList of animals : " + animals + "\n";
	}
}
