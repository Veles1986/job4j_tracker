package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenCreateItem() {
        Input input = new MockInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Item item = new Item("name");
        Tracker tracker = new Tracker();
        tracker.add(item);
        Input input = new MockInput(
                new String[] {"0", "1", "New name", "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("New name");
    }

    @Test
    void whenDeleteItem() {
        Item item = new Item("name");
        Tracker tracker = new Tracker();
        tracker.add(item);
        Input input = new MockInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        Item expected = null;
        assertThat(expected).isEqualTo(tracker.findById(item.getId()));
    }
}