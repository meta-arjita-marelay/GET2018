package Question1;

import java.util.ArrayList;
import java.util.List;

/**
 * ZooManagement will manage all the zones, cages and animals of zoo.
 * 
 * @author Arjita
 *
 */
public class ZooManagement {
	private int capacity;// capacity of zones.
	private List<Zone> listOfZones = new ArrayList<Zone>();

	/**
	 * Constructor to initialise the private member.
	 * 
	 * @param capacity
	 *            of zones.
	 */
	public ZooManagement(int capacity) {
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	/**
	 * addZone will add zone in zoo.
	 * 
	 * @param zone
	 *            object of zone which is to be added
	 * @return true if it can be added otherwise false
	 */
	public boolean addZone(Zone zone) {
		if (listOfZones.size() < capacity) {
			listOfZones.add(zone);
			return true;
		} else {
			System.out.println("Zoo has reached its limit. Cannot add zone.");
			return false;
		}
	}

	/**
	 * addCage will add cage to zone.
	 * 
	 * @param cage
	 *            object of cage which is to be added
	 * @return true if it is be added otherwise false
	 */
	public boolean addCage(Cage cage) {
		for (Zone zone : listOfZones) {
			if (cage.getCategoryOfZone() == zone.getCategoryOfZone()) {
				if (zone.addCage(cage)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * addAnimal will add animal in cage.
	 * 
	 * @param animal
	 *            object of animal which is to be added.
	 * @return true if it is added otherwise false.
	 */
	public boolean addAnimal(Animal animal) {
		for (Zone zone : listOfZones) {
			if (zone.getCategoryOfZone() == animal.getCategory()) {
				if (zone.addAnimal(animal, listOfZones.indexOf(zone))) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
}
