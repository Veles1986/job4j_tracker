package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String original, String duplicate) {
        boolean result = true;
        String[] origin = original.split(" ");
        String[] text = duplicate.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String partOfText : origin) {
            check.add(partOfText);
        }
        for (String partOfText : text) {
            if (!check.contains(partOfText)) {
                result = false;
            }
        }
        return result;
    }
}
