package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        if (!this.tasks.isEmpty()) {
            for (Task element : tasks) {
                if (element.getPriority() > task.getPriority()) {
                    break;
                }
                index++;
            }
            if (index == tasks.size()) {
                tasks.add(task);
                return;
            }
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }
}
