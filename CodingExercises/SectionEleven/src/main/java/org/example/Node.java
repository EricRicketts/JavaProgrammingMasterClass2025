package org.example;

public class Node extends ListItem {

    private ListItem next;
    private ListItem previous;
    private Object value;

    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return next;
    }

    @Override
    ListItem setNext(ListItem next) {
        this.next = next;
        return next;
    }

    @Override
    ListItem previous() {
        return previous;
    }

    @Override
    ListItem setPrevious(ListItem previous) {
        this.previous = previous;
        return previous;
    }
}
