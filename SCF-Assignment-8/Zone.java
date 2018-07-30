package Question1;

import java.util.ArrayList;
import java.util.List;

/**
 * Zone contains properties of zone, check and add cage in zone.
 * 
 * @author Arjita
 *
 */
public class Zone {
	private int capacity;// capacity of cages
	private Category category;// category of animal
	boolean hasPark, hasCanteen;
	private List<Cage> listOfCages = new ArrayList<Cage>();

	public Zone(int capacity, Category category2, boolean hasPark,
			boolean hasCanteen) {
		this.capacity = capacity;
		this.category = category2;
		this.hasPark = hasPark;
		this.hasCanteen = hasCanteen;
	}

	public int getCapacity() {
		return capacity;
	}

	public Category getCategoryOfZone() {
		return category;
	}

	/**
	 * addCage will add cage in zone if there is no more cage available.
	 * 
	 * @param cage
	 *            object of class cage which is to be added in zone.
	 * @return true if it can be added according to limit of zone otherwise
	 *         false
	 */
	public boolean addCage(Cage cage) {
		if (category == cage.getCategoryOfZone()) {
			if (listOfCages.size() < capacity) {
				listOfCages.add(cage);
				return true;
			} else {
				System.out
						.println("Zone has reached it's limit. Can not add cage.");
				return false;
			}

		} else {
			System.out
					.println("Can not add the cage to this category of zone.");
			return false;
		}
	}

	/**
	 * addAnimal will add animal in cage.
	 * 
	 * @param animal
	 *            object of animal which is to be added.
	 * @param zone
	 *            in which animal is to be added
	 * @return true if animal can be added.
	 */
	public boolean addAnimal(Animal animal, int zone) {
		for (Cage cage : listOfCages) {
			if (cage.getTypeOfAnimal() == animal.getType()) {
				if (cage.addAnimal(animal, zone, listOfCages.indexOf(cage))) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
}
