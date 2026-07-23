package org.example;

import java.util.Objects;

public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return this.rightLink;
    }

    @Override
    ListItem setNext(ListItem newRightLink) {
        this.rightLink = newRightLink;
        return this.rightLink;
    }

    @Override
    ListItem previous() {
        return this.leftLink;
    }

    @Override
    ListItem setPrevious(ListItem newLeftLink) {
        this.leftLink = newLeftLink;
        return this.leftLink;
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
