package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    private static final String CHEESE_NAME = " with extra cheese";

    public String name() {
        return super.name() + CHEESE_NAME;
    }
}
