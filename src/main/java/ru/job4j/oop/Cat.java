package ru.job4j.oop;

public class Cat {

    private String food;

    private String name;

    public void show() {
        System.out.println("Name: " + this.name);
        System.out.println("Food: " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        System.out.println("There is info about gav");
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.giveNick("Gav");
        gav.show();
        System.out.println("There is info about black");
        Cat black = new Cat();
        black.eat("fish");
        black.giveNick("Black");
        black.show();
    }
}
