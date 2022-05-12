package ru.yandex.embosser;

public class Praktikum {

    public static void main(String[] args) {

        for (String name : args) {
            Account account = new Account(name);
            System.out.println(account.checkNameToEmboss());
        }

    }
}