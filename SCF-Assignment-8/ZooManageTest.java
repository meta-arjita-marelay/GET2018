package Question1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
public class ZooManageTest {
    
    ZooManagement zoo = new ZooManagement(2);
    
    @Before
    public void init() {
        
    }

    @Test
    public void test() {
        Category categoryMammal = Category.Mammal;
        TypeOfAnimal animalType = TypeOfAnimal.Tiger;

        Zone zoneMammal = new Zone(5, categoryMammal, true, true);
        
        Cage cageMammal = new Cage(1, categoryMammal, animalType);

        zoo.addZone(zoneMammal);
        zoo.addCage(cageMammal);
        
        Animal tiger = new Tiger("Shera", 5, "MEOW");
        
        
        assertEquals(true, zoo.addAnimal(tiger));

        
        System.out.print(cageMammal.getInfo());
        System.out.print(tiger.getInfo());
    }

    

    @Test
    public void test2() {
        Category categoryBird = Category.Bird;
        TypeOfAnimal animalType = TypeOfAnimal.Peacock;

        Zone zoneBird = new Zone(5, categoryBird, true, true);
        
        Cage cageBird = new Cage(1, categoryBird, animalType);

        zoo.addZone(zoneBird);
        zoo.addCage(cageBird);
        
        Animal peacock = new Peacock("Raju", 2, "Cookdookoo", 20);
        
        assertEquals(true, zoo.addAnimal(peacock));

    }


    @Test
    public void test3() {
        Category categoryReptile = Category.Reptile;
        TypeOfAnimal animalType = TypeOfAnimal.Crocodile;

        Zone zoneReptile = new Zone(5, categoryReptile, true, true);
        
        Cage cageReptile = new Cage(1, categoryReptile, animalType);

        zoo.addZone(zoneReptile);
        zoo.addCage(cageReptile);
        
        Animal crocodile = new Crocodile("Raju", 2, "Cookdookoo", 20);
        
        assertEquals(true, zoo.addAnimal(crocodile));

    }


    @Test
    public void test4() {
        Category categoryReptile = Category.Reptile;
        TypeOfAnimal animalType = TypeOfAnimal.Lizard;

        Zone zoneReptile = new Zone(5, categoryReptile, true, true);
        
        Cage cageReptile = new Cage(1, categoryReptile, animalType);

        zoo.addZone(zoneReptile);
        zoo.addCage(cageReptile);
        
        Animal crocodile = new Crocodile("Raju", 2, "Cookdookoo", 20);
        
        assertNotEquals(true, zoo.addAnimal(crocodile));

    }

}
