package org.example;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

public class NewQueryList <T extends QueryItem> extends ArrayList<T> {

    public NewQueryList() {
    }

    public static <T extends QueryItem> List<T> getMatches(List<T> items, String field, String value) {
        List<T> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }
}
