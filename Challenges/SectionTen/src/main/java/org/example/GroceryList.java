package org.example;

import java.util.ArrayList;
import java.util.Comparator;

public class GroceryList {

    private final ArrayList<String> list;
    public GroceryList() {
        this.list = new ArrayList<>();
    }

    public void addItems(String listOfItems) {
        String[] items = listOfItems.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (!this.list.contains(trimmedItem)) {
                this.list.add(trimmedItem);
            }
        }
    }

    public void removeItems(String listOfItems) {
        String[] items = listOfItems.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            this.list.remove(trimmedItem);
        }
    }

    public String printList() {
        this.list.sort(Comparator.naturalOrder());
        String listOutput = "";
        for (String item : this.list) {
            listOutput = listOutput.concat(item + "\n");
        }
        return listOutput.stripTrailing();
    }
}
