package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {
    @Test
    void whenItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item(342, "Sergey"),
                new Item(453, "Bogdan"),
                new Item(921, "Nikolay"),
                new Item(285, "Petr")
        );

        List<Item> expected = Arrays.asList(
                new Item(453, "Bogdan"),
                new Item(921, "Nikolay"),
                new Item(285, "Petr"),
                new Item(342, "Sergey")
        );
        Collections.sort(items, new ItemAscByName());
        assertThat(expected).isEqualTo(items);
    }
}