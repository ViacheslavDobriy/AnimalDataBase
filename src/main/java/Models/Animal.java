package Models;

import java.util.List;

public class Animal {
    private int Id;
    private String name;
    private int age;

    private  List<String> listOfCommands;
    public void setId(int id) {
        this.Id = id;
    }

    public  List<String> getListOfCommands() {
        return listOfCommands;
    }
    public void setNewCommand(String newCommand){
        listOfCommands.add(newCommand);
    }
}
