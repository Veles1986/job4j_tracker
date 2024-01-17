package ru.job4j.oop;

public class Calculator {

    private static int x = 60;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int multiply(int y) {
        return x * y;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + this.multiply(y)  + this.divide(y);
    }

    public static void main(String[] args) {
        System.out.println(sum(34));
        System.out.println(minus(23));
        Calculator result = new Calculator();
        System.out.println((result.divide(20)));
        System.out.println(result.multiply(3));
        System.out.println(result.sumAllOperation(12));
    }
}
