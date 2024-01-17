package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class PointTest {
    @Test
    void whenMinus37To8Minus4Then15Dot556() {
        double expected = 15.556;
        Point first = new Point(-3, 7);
        Point second = new Point(8, -4);
        double output = first.distance(second);
        assertThat(output).isCloseTo(expected, withPrecision(0.001));
    }

    @Test
    void when92ToMinus622Then25() {
        double expected = 25;
        Point first = new Point(9, 2);
        Point second = new Point(-6, 22);
        double output = first.distance(second);
        assertThat(output).isEqualTo(expected);
    }

    @Test
    void whenMinus8Minus7To217Then26() {
        double expected = 26;
        Point first = new Point(-8, -7);
        Point second = new Point(2, 17);
        double output = first.distance(second);
        assertThat(output).isEqualTo(expected);
    }

    @Test
    void when7Minus513To319MinusThen29Point682() {
        double expected = 29.682;
        Point first = new Point(7, -5, 13);
        Point second = new Point(3, 19, -4);
        double output = first.distance3d(second);
        assertThat(output).isCloseTo(expected, withPrecision(0.001));
    }

    @Test
    void when148Minus9To1751Then10Point863() {
        double expected = 10.863;
        Point first = new Point(14, 8, -9);
        Point second = new Point(17, 5, 1);
        double output = first.distance3d(second);
        assertThat(output).isCloseTo(expected, withPrecision(0.001));
    }
}