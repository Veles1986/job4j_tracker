package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {
    @Test
    void whenItemAscByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(342, "Sergey"));
        items.add(new Item(453, "Bogdan"));
        items.add(new Item(921, "Nikolay"));
        items.add(new Item(285, "Petr"));
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(342, "Sergey"));
        expected.add(new Item(285, "Petr"));
        expected.add(new Item(921, "Nikolay"));
        expected.add(new Item(453, "Bogdan"));
        Collections.sort(items, new ItemDescByName());
        assertThat(expected).isEqualTo(items);
    }
}