package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QueryListChallenge<T extends QueryItemChallenge> extends ArrayList<T> {

    public QueryListChallenge(Collection<T> data) {
        super(data);
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


    /*
    public List<T> getMatches(String field, String value) {

        List<T> matches = new ArrayList<>();
        for (var item : this.getItems()) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }
*/
}
