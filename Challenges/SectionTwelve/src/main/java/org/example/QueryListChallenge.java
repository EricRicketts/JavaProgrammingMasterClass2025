package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QueryListChallenge<T extends NewLPAStudent & QueryItemChallenge> extends ArrayList<T> {

    public QueryListChallenge(List<T> data) {
        super(data);
    }

    public QueryListChallenge() {}

    public QueryListChallenge<T> getMatches(String field, String value) {
        QueryListChallenge<T> matches = new QueryListChallenge<>();
        for (var item : this) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }
}
