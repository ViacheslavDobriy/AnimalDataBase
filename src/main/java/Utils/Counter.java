package Utils;

public class Counter {
    private static int id;

    /**
     * Счётчик применяемый для присвоения id сущностям, занесённым в питомник.
     * @return текущий (int)id.
     */
    public int add(){
        return id++;
    }
}
