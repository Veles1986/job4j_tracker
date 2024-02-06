package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                return i;
            }
        }
        throw new ElementNotFoundException("Element not found");
    }

    public static void main(String[] args) {
        String[] value = {"Василий", "Петр", "Николай", "Иван"};
        try {
            indexOf(value, "Евгений");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
