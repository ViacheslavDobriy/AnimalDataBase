package Models;

import Utils.Counter;

import java.util.ArrayList;
import java.util.List;

public class Nursery {


    Counter idCounter;
    private static List<Animal> animals;

    public Nursery(Counter counter) {
        this.idCounter = counter;
        animals = new ArrayList<>();
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void addNewAnimal(Animal animal){
        animal.setId(idCounter.add());
        animals.add(animal);
    }

    public int getLength(){
        return animals.size();
    }


}