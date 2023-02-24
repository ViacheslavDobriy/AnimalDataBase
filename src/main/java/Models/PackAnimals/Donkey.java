package Models.PackAnimals;

import Models.PackAnimal;

import java.util.ArrayList;
import java.util.List;

public class Donkey extends PackAnimal {
    private int id;
    private String name;
    private int age;
    private List<String> listOfCommands;

    public Donkey(String name, int age) {
        this.name = name;
        this.age = age;
        listOfCommands = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public  List<String> getListOfCommands() {
        return listOfCommands;
    }
    public void setNewCommand(String newCommand){
        listOfCommands.add(newCommand);
    }

    @Override
    public String toString() {
        return "Donkey{" +
                "donkeyId=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
