package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        int number = 1;
        for (int i = 0; i < queue.size();) {
            if (number == count) {
                return queue.peek().name();
            }
            queue.poll();
            number++;
        }
        return "";
    }

    public String getFirstUpsetCustomer() {
        int number = 1;
        for (int i = 0; i < queue.size();) {
            if (number > count) {
                 return queue.peek().name();
            }
            queue.poll();
            number++;
        }
        return "";
    }
}
