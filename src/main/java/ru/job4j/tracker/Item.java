package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        Item item1 = new Item();
        item1.printInfo();
        Item item2 = new Item("Laptop");
        item2.printInfo();
        Item item3 = new Item(23, "cup");
        item3.printInfo();
    }
}