package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LambdaExpressionsTest {


    String extraToString(String string) {
        return string + "\n";
    }

    List<String> list;

    @BeforeEach
    public void setUp() {
        list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));
    }

    @Test
    public void testFirstToStringMethods() {
        String expected = "alpha\nbravo\ncharlie\ndelta\n";

        String firstResult = "";
        for(String letter : list) {
            firstResult = firstResult.concat(extraToString(letter));
        }

        assertEquals(expected, firstResult);
    }

    @Test
    public void testSecondToStringMethods() {
        String expected = "alpha\nbravo\ncharlie\ndelta\n";

        StringBuilder secondResult = new StringBuilder();
        list.forEach((s) -> secondResult.append(extraToString(s)));

        assertEquals(expected, secondResult.toString());
    }

    @Test
    public void testSecondToStringMethodsWithCodeBlock() {
        String expected = "alpha means a\nbravo means b\ncharlie means c\ndelta means d\n";

        StringBuilder secondResult = new StringBuilder();
        list.forEach(myString -> {
            char first = myString.charAt(0);
            secondResult.append(myString).append(" means ").append(first).append("\n");
        });

        assertEquals(expected, secondResult.toString());
    }

    @Test
    public void testSecondToStringMethodsWithPrefix() {
        String expected = """
            Nato alpha means a
            Nato bravo means b
            Nato charlie means c
            Nato delta means d
            """;

        StringBuilder secondResult = new StringBuilder();
        String prefix = "Nato";
        list.forEach(myString -> {
            char first = myString.charAt(0);
            secondResult.append(prefix).append(" ").append(myString)
                .append(" means ").append(first).append("\n");
        });

        assertEquals(expected, secondResult.toString());
    }

    @Test
    public void testSecondToStringMethodWithFinalVariation() {
        /*
            I wanted to run this test method just for using the
            forEach method on the list.  Other tests will show a
            more shortened and robust way to update the list.

            I did not understand the scoping rules of forEach and
            its associated lambda expression.  When writing s =
            s.concat(...), s is simply reassigned a new String object
            in memory within the scope of the given lambda expression.

            Reassigning the local variable s does not update the index
            value inside the list.

            What needs to be done, as shown below, is to introduce
            a local variable, in this case a list of strings, scoped
            in such a way that it can absorb the changes to each
            individual string.  Note the lambda expression has access
            to the local variable declared outside the code block.
        */
       List<String> expected = new ArrayList<>(
           List.of(
               "alpha ends with a\n",
                "bravo ends with o\n",
                "charlie ends with e\n",
                "delta ends with a\n"
           )
       );
       List<String> modifiedList = new ArrayList<>();
        list.forEach(s -> {
            String updated = s.concat(" ends with ")
                .concat(String.valueOf(s.charAt(s.length() - 1)))
                .concat("\n");
                modifiedList.add(updated);
        });

        assertEquals(expected, modifiedList);
    }

    @Test
    public void testUpdateSecondStringAMoreElegantWay() {
        List<String> expected = new ArrayList<>(
            List.of(
                "alpha ends with a\n",
                "bravo ends with o\n",
                "charlie ends with e\n",
                "delta ends with a\n"
            )
        );
        list.replaceAll( s -> s.concat(" ends with ")
            .concat(String.valueOf(s.charAt(s.length() - 1)))
            .concat("\n"));

        assertEquals(expected, list);
    }
}
