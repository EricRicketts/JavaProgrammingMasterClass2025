package org.example;

import java.util.Comparator;
import java.util.Objects;

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

    @Override
    int compareTo(ListItem listItem) {
        int first = (int) this.getValue();
        int second = (int) listItem.getValue();
        if (first > second ) {
            return 1;
        } else if (first < second) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;

        Node node = (Node) object;
        return Objects.equals(this.getValue(), node.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getValue());
    }
}
