package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder text = new StringBuilder();
        int limit = evenElements.size();
        for (int i = 0; i < limit; i++) {
            text.append(evenElements.poll());
        }
        return text.toString();
    }

    private String getDescendingElements() {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < descendingElements.size();) {
            text.append(descendingElements.pollLast());
        }
        return text.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}