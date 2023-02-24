package View;

import Models.Animal;
import Models.Nursery;
import Models.PackAnimals.Camel;
import Models.PackAnimals.Donkey;
import Models.PackAnimals.Horse;
import Models.PackAnimals.PackAnimalsEnum;
import Models.Pets.Cat;
import Models.Pets.Dog;
import Models.Pets.Hamster;
import Models.Pets.PetsEnum;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleView {

    Nursery nursery;

    public ConsoleView(Nursery nursery) {
        this.nursery = nursery;
    }

    /**
     * Основной метод ConsoleView, реализует взаимодействие с пользователем,
     * навигацию по меню.
     */
    public void start(){
        Scanner scanner = new Scanner(System.in);
        String userChoice;
        while (true){
            System.out.println("Что будем делать...\n" +
                    "1 - Просмотреть информацию о животных в питомнике.\n" +
                    "2 - Добавить новое животное.\n" +
                    "3 - Изменить список команд какого-либо животного.\n" +
                    "4 - Закончить сеанс.");
            userChoice = scanner.next();
            if (Objects.equals(userChoice, "1")){
                showAnimals();
            }
            if (Objects.equals(userChoice, "2")){
                addNewAnimal();
            }
            if (Objects.equals(userChoice, "3")){
                editConcreteCommandsList();
            }
            if (Objects.equals(userChoice, "4")){
                System.out.println("До следующих встреч!");
                scanner.close();
                break;
            }
        }
    }

    /**
     * Метод изменения списка команд конкретного животного.
     */
    private void editConcreteCommandsList(){
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        String newCommand;
        while (true){
            System.out.println("Введите id интересующего животного: ");
            userChoice = scanner.nextInt();

            if (userChoice > 0 || userChoice < nursery.getLength()){
                System.out.println("Введите добавляемую команду: ");
                newCommand = scanner.nextLine();
                List<Animal> animalList = nursery.getAnimals();
                animalList.get(userChoice).setNewCommand(newCommand);
                System.out.println("Команда добавлена.");
                break;
            }else {
                System.out.println("Введите корректное значение!\n");
            }
        }
        scanner.close();
    }
    private void showAnimals(){
        List<Animal> animalList = nursery.getAnimals();
        for (Animal animal : animalList) {
            System.out.println(animal.toString());
            if (animal.getListOfCommands().size() == 0){
                System.out.println("Животное не обучено командам.");
            }else {
                System.out.println(animal.getListOfCommands());
            }
        }
        System.out.println("\n");
    }

    /**
     * Метод добавления нового животного в питомник.
     */
    private void addNewAnimal(){
        Scanner scanner = new Scanner(System.in);

        String choice;
        String type;
        String name;
        int age;

        while (true){
            System.out.println("Животное какой категории вы хотите добавить?\n" +
                    "1 - Домашнее животное.\n" +
                    "2 - Вьючное животное.");
            choice = scanner.nextLine();
            if (Objects.equals(choice, "1")){
                PetsEnum[] list = PetsEnum.values();

                System.out.println("Введите значение из представленных: ");
                for (int i = 0; i < list.length; i++) {
                    System.out.println(list[i]);
                }
                type = scanner.next();
                if (Objects.equals(type, "CAT")){
                    System.out.println("Введите имя: ");
                    name = scanner.next();
                    System.out.println("Введите возраст: ");
                    age = scanner.nextInt();
                    Cat newCat = new Cat(name, age);
                    nursery.addNewAnimal(newCat);
                    System.out.println("Животное добавлено.\n");
                    break;
                }
                if (Objects.equals(type, "DOG")){
                    System.out.println("Введите имя: ");
                    name = scanner.next();
                    System.out.println("Введите возраст: ");
                    age = scanner.nextInt();
                    Dog newDog = new Dog(name, age);
                    nursery.addNewAnimal(newDog);
                    System.out.println("Животное добавлено.\n");
                    break;
                }
                if (Objects.equals(type, "HAMSTER")){
                    System.out.println("Введите имя: ");
                    name = scanner.next();
                    System.out.println("Введите возраст: ");
                    age = scanner.nextInt();
                    Hamster newHamster = new Hamster(name, age);
                    nursery.addNewAnimal(newHamster);
                    System.out.println("Животное добавлено.\n");
                    break;
                }
                else {
                    System.out.println("Введите корректное значение!\n");
                }
            }
            if (Objects.equals(choice, "2")){
                PackAnimalsEnum[] list = PackAnimalsEnum.values();

                System.out.println("Введите значение из представленных: ");
                for (int i = 0; i < list.length; i++) {
                    System.out.println(list[i]);
                }
                type = scanner.next();
                if (Objects.equals(type, "CAMEL")){
                    System.out.println("Введите имя: ");
                    name = scanner.next();
                    System.out.println("Введите возраст: ");
                    age = scanner.nextInt();
                    Camel newCamel = new Camel(name, age);
                    nursery.addNewAnimal(newCamel);
                    System.out.println("Животное добавлено.\n");
                    break;
                }
                if (Objects.equals(type, "HORSE")){
                    System.out.println("Введите имя: ");
                    name = scanner.next();
                    System.out.println("Введите возраст: ");
                    age = scanner.nextInt();
                    Horse newHorse = new Horse(name, age);
                    nursery.addNewAnimal(newHorse);
                    System.out.println("Животное добавлено.\n");
                    break;
                }
                if (Objects.equals(type, "DONKEY")){
                    System.out.println("Введите имя: ");
                    name = scanner.next();
                    System.out.println("Введите возраст: ");
                    age = scanner.nextInt();
                    Donkey newDonkey = new Donkey(name, age);
                    nursery.addNewAnimal(newDonkey);
                    System.out.println("Животное добавлено.\n");
                    break;
                }
                else {
                    System.out.println("Введите корректное значение!\n");
                }
            }
            else {
                System.out.println("Введите корректное значение!\n");
            }
        }
        scanner.close();
    }
}
