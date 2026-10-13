package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

public class MethodReferenceChallengeTest {

    private static final Random RANDOM = new Random();

    private static String addReversedLastName(String name) {
        String copy = String.valueOf(name);
        return new StringBuilder(copy).reverse().toString();
    }

    private static String addMiddleInitial(String name) {
        char initial = (char) ('A' + RANDOM.nextInt(26));
        return name + " " + initial + ".";
    }

    private String[] names = {
        "James", "Dilbert", "Oliver", "Zachary", "Norman", "Frederick"
    };

    private UnaryOperator<String> unary, u, t;

    @BeforeEach
    public void setUp() {
        u = MethodReferenceChallengeTest::addMiddleInitial;
        t = MethodReferenceChallengeTest::addReversedLastName;
    }


    @Test
    public void testConvertNamesToUpperCase() {
        List<String> list = Arrays.asList(names);
        list.replaceAll(String::toUpperCase);
        String[] expected = list.toArray(String[]::new);

        unary = String::toUpperCase;
        for (String name : names) {
            name = name.transform(unary);
        }

        assertArrayEquals(expected, names);
    }

    @Test
    public void testConvertNamesByAddingAnMiddleInitial() {
        List<String> list = Arrays.asList(names);
        list.replaceAll(u);

        for (String name : names) {
            assertTrue(name.matches("^[A-Za-z]+ [A-Z]\\.$"));
        }
    }

    @Test
    public void testConvertNamesByAddingLastNameWhichIsReversedFirstName() {
        String[] originalNames = {
            "James", "Dilbert", "Oliver", "Zachary", "Norman", "Frederick"
        };
        List<String> list = Arrays.asList(names);
        list.replaceAll(t);

        List<String> reversedNames = new ArrayList<>();
        for (int index = names.length - 1; index >= 0; index-=1) {
            reversedNames.add(new StringBuilder(originalNames[index]).reverse().toString());
        }
        reversedNames = reversedNames.reversed();

        for (int index = 0; index < names.length; index+=1) {
            String expected = reversedNames.get(index);
            String result = names[index];

            assertEquals(expected, result);
        }
    }
}
