import Models.Animal;
import Models.Nursery;
import Models.PackAnimals.Horse;
import Models.Pets.Cat;
import Models.Pets.Dog;
import Models.Pets.PetsEnum;
import Utils.Counter;
import View.ConsoleView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Nursery nursery = new Nursery(new Counter());
        ConsoleView consoleView = new ConsoleView(nursery);


        consoleView.start();
    }
}
