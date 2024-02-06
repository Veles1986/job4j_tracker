package ru.job4j.tracker;

public class StubOutput implements Output {
    private final StringBuilder buffer = new StringBuilder();

    @Override
    public void println(Object object) {
        if (object != null) {
            buffer.append(object.toString());
            buffer.append(System.lineSeparator());
        } else {
            buffer.append("null");
        }
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}
