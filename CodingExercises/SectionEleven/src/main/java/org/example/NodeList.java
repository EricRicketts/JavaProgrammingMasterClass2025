package org.example;

public interface NodeList {

    ListItem getRoot();

    String addItem(ListItem item);

    String removeItem(ListItem item);

    String traverse(ListItem root);
}
