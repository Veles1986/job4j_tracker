package ru.job4j.collection;

import java.util.Comparator;

public class SortByNameJob implements Comparator<Job> {
    public int compare(Job left, Job right) {
        return left.getName().compareTo(right.getName());
    }
}
