package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    void whenAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Thor", 8),
                new Job("Peter Parker", 3),
                new Job("Tony Stark", 2),
                new Job("Hulk", 5),
                new Job("Black Widow", 4)
        );
        List<Job> expected = Arrays.asList(
                new Job("Black Widow", 4),
                new Job("Hulk", 5),
                new Job("Peter Parker", 3),
                new Job("Thor", 8),
                new Job("Tony Stark", 2)
        );
        Comparator<Job> comparator = new JobAscByName();
        Collections.sort(jobs, comparator);
        assertThat(expected).isEqualTo(jobs);
    }

    @Test
    void whenDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Thor", 8),
                new Job("Peter Parker", 3),
                new Job("Tony Stark", 2),
                new Job("Hulk", 5),
                new Job("Black Widow", 4)
        );
        List<Job> expected = Arrays.asList(
                new Job("Tony Stark", 2),
                new Job("Thor", 8),
                new Job("Peter Parker", 3),
                new Job("Hulk", 5),
                new Job("Black Widow", 4)
        );
        Comparator<Job> comparator = new JobDescByName();
        Collections.sort(jobs, comparator);
        assertThat(expected).isEqualTo(jobs);
    }

    @Test
    void whenAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Thor", 8),
                new Job("Peter Parker", 3),
                new Job("Tony Stark", 2),
                new Job("Hulk", 5),
                new Job("Black Widow", 4)
        );
        List<Job> expected = Arrays.asList(
                new Job("Tony Stark", 2),
                new Job("Peter Parker", 3),
                new Job("Black Widow", 4),
                new Job("Hulk", 5),
                new Job("Thor", 8)
        );
        Comparator<Job> comparator = new JobAscByPriority();
        Collections.sort(jobs, comparator);
        assertThat(expected).isEqualTo(jobs);
    }

    @Test
    void whenDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Thor", 8),
                new Job("Peter Parker", 3),
                new Job("Tony Stark", 2),
                new Job("Hulk", 5),
                new Job("Black Widow", 4)
        );
        List<Job> expected = Arrays.asList(
                new Job("Thor", 8),
                new Job("Hulk", 5),
                new Job("Black Widow", 4),
                new Job("Peter Parker", 3),
                new Job("Tony Stark", 2)
        );
        Comparator<Job> comparator = new JobDescByPriority();
        Collections.sort(jobs, comparator);
        assertThat(expected).isEqualTo(jobs);
    }

    @Test
    void whenAscByNameThenAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Thor", 8),
                new Job("Peter Parker", 3),
                new Job("Tony Stark", 2),
                new Job("Hulk", 5),
                new Job("Black Widow", 4),
                new Job("Thor", 3),
                new Job("Peter Parker", 2),
                new Job("Tony Stark", 5),
                new Job("Hulk", 4),
                new Job("Black Widow", 8)
        );
        List<Job> expected = Arrays.asList(
                new Job("Black Widow", 4),
                new Job("Black Widow", 8),
                new Job("Hulk", 4),
                new Job("Hulk", 5),
                new Job("Peter Parker", 2),
                new Job("Peter Parker", 3),
                new Job("Thor", 3),
                new Job("Thor", 8),
                new Job("Tony Stark", 2),
                new Job("Tony Stark", 5)
        );
        Comparator<Job> comparator = new JobAscByName().thenComparing(new JobAscByPriority());
        Collections.sort(jobs, comparator);
        assertThat(expected).isEqualTo(jobs);
    }

    @Test
    void whenAscByNameThenDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Thor", 8),
                new Job("Peter Parker", 3),
                new Job("Tony Stark", 2),
                new Job("Hulk", 5),
                new Job("Black Widow", 4),
                new Job("Thor", 3),
                new Job("Peter Parker", 2),
                new Job("Tony Stark", 5),
                new Job("Hulk", 4),
                new Job("Black Widow", 8)
        );
        List<Job> expected = Arrays.asList(
                new Job("Black Widow", 8),
                new Job("Black Widow", 4),
                new Job("Hulk", 5),
                new Job("Hulk", 4),
                new Job("Peter Parker", 3),
                new Job("Peter Parker", 2),
                new Job("Thor", 8),
                new Job("Thor", 3),
                new Job("Tony Stark", 5),
                new Job("Tony Stark", 2)
        );
        Comparator<Job> comparator = new JobAscByName().thenComparing(new JobDescByPriority());
        Collections.sort(jobs, comparator);
        assertThat(expected).isEqualTo(jobs);
    }

    @Test
    void whenDescByNameThenAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Thor", 8),
                new Job("Peter Parker", 3),
                new Job("Tony Stark", 2),
                new Job("Hulk", 5),
                new Job("Black Widow", 4),
                new Job("Thor", 3),
                new Job("Peter Parker", 2),
                new Job("Tony Stark", 5),
                new Job("Hulk", 4),
                new Job("Black Widow", 8)
        );
        List<Job> expected = Arrays.asList(
                new Job("Tony Stark", 2),
                new Job("Tony Stark", 5),
                new Job("Thor", 3),
                new Job("Thor", 8),
                new Job("Peter Parker", 2),
                new Job("Peter Parker", 3),
                new Job("Hulk", 4),
                new Job("Hulk", 5),
                new Job("Black Widow", 4),
                new Job("Black Widow", 8)
        );
        Comparator<Job> comparator = new JobDescByName().thenComparing(new JobAscByPriority());
        Collections.sort(jobs, comparator);
        assertThat(expected).isEqualTo(jobs);
    }

    @Test
    void whenDescByNameThenDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Thor", 8),
                new Job("Peter Parker", 3),
                new Job("Tony Stark", 2),
                new Job("Hulk", 5),
                new Job("Black Widow", 4),
                new Job("Thor", 3),
                new Job("Peter Parker", 2),
                new Job("Tony Stark", 5),
                new Job("Hulk", 4),
                new Job("Black Widow", 8)
        );
        List<Job> expected = Arrays.asList(
                new Job("Tony Stark", 5),
                new Job("Tony Stark", 2),
                new Job("Thor", 8),
                new Job("Thor", 3),
                new Job("Peter Parker", 3),
                new Job("Peter Parker", 2),
                new Job("Hulk", 5),
                new Job("Hulk", 4),
                new Job("Black Widow", 8),
                new Job("Black Widow", 4)
        );
        Comparator<Job> comparator = new JobDescByName().thenComparing(new JobDescByPriority());
        Collections.sort(jobs, comparator);
        assertThat(expected).isEqualTo(jobs);
    }
}