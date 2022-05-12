package ru.yandex.embosser;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        return name!=null&&name.matches("(?=^\\D{3,19}$)([A-Za-zА-Яа-я]+\\s+[A-Za-zА-Яа-я]+$)");
    }
}