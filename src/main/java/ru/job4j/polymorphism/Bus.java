package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Автобус поехал");
    }

    @Override
    public void passengers(int numberOfPassengers) {
        System.out.println("В автобусе " + numberOfPassengers + " пассажиров");
    }

    @Override
    public double refill(double amountOfFuel) {
        return amountOfFuel * 2.5;
    }
}
