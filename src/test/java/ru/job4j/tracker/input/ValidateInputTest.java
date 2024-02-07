package ru.job4j.tracker.input;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(in, output);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenInputIsValidOnce() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"2"}
        );
        ValidateInput input = new ValidateInput(in, output);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(2);
    }

    @Test
    void whenInputIsValidMultiple() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"2", "3", "7", "12", "1"}
        );
        ValidateInput input = new ValidateInput(in, output);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(2);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(3);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(7);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(12);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenInputIsValidWithNegativeNumber() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"-22"}
        );
        ValidateInput input = new ValidateInput(in, output);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-22);
    }
}