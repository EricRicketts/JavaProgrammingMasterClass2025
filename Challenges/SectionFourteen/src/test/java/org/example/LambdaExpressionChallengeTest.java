package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class LambdaExpressionChallengeTest {

    private static char getRandomChar(char startChar, char endChar, Random random) {
        return (char) random.nextInt((int) startChar, (int) endChar + 1);
    }

    private static String getReversedName(String name) {
        String reversedName = new StringBuilder(name).reverse().toString().toLowerCase();
        return reversedName.substring(0, 1).toUpperCase().concat(reversedName.substring(1));
    }

    private String[] names = {"Bob", "George", "William", "Eric", "Marty", "Anna", "Racecar", "Deified"};
    private String[] expected;
    private List<String> listOfNames;
    private Random random;

    @BeforeEach
    public void setUp() {
        listOfNames = new ArrayList<>(List.of(names));
        random = new Random();
    }

    @Test
    public void testTransformNamesToAllUpperCase() {
        Arrays.setAll(names, i -> names[i].toUpperCase());

        expected = new String[]{"BOB", "GEORGE", "WILLIAM", "ERIC", "MARTY", "ANNA", "RACECAR", "DEIFIED"};

        assertArrayEquals(expected, names);
    }

    @Test
    public void testAddMiddleInitialAndPeriod() {
        String[] letters = {
            "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P",
            "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "Z"
        };

        String[] copyOfNames = Arrays.copyOf(names, names.length);
        Random random = new Random();
        Arrays.setAll(names,
            i -> names[i].concat(" ").concat(letters[random.nextInt(letters.length)]).concat(".")
            );

        for (int index = 0; index < names.length; index+=1) {
            String currentName = names[index];
            var separateNames = currentName.split("\\s+");
            var firstName = separateNames[0];
            var middleInitial = separateNames[1];

            assertEquals(copyOfNames[index], firstName);
            assertTrue(Arrays.asList(letters).contains(middleInitial.substring(0, 1)));
            assertEquals(".", middleInitial.substring(1));
        }
    }

    @Test
    public void testAddingALastNameWhichIsTheReverseOfTheFirstName() {
        Arrays.setAll(names, i -> names[i]
            .concat(" ")
            .concat(String.valueOf(new StringBuilder(names[i]).reverse())
                .toLowerCase().substring(0, 1).toUpperCase()
                .concat(String.valueOf(new StringBuilder(names[i]).reverse()).toLowerCase().substring(1))
        ));

        String[] expected = {
            "Bob Bob", "George Egroeg", "William Mailliw", "Eric Cire",
            "Marty Ytram", "Anna Anna", "Racecar Racecar", "Deified Deified"
        };

        assertArrayEquals(expected, names);
    }

    @Test
    public void testRemoveNameIfLastNameEqualsFirstName() {
        List<String> listOfNames = new ArrayList<>(Arrays.asList(names));
        listOfNames.removeIf( name -> name.equalsIgnoreCase(
            String.valueOf(new StringBuilder(name).reverse())
            )
        );

        String[] names = listOfNames.toArray(new String[0]);

        String[] expected = {"George", "William", "Eric", "Marty"};

        assertArrayEquals(expected, names);
    }

    @Test
    public void testAddLastNameWithMethod() {
        String letter = String.valueOf(getRandomChar('A', 'Z', random));
        Arrays.setAll(names, i -> names[i]
            .concat(" " + letter + ". ").concat(getReversedName(names[i]))
        );

        String[] expectedFirstNames = {
            "Bob", "George", "William", "Eric",
            "Marty", "Anna", "Racecar", "Deified"
        };
        String[] expectedLastNames = {
            "Bob", "Egroeg", "Mailliw", "Cire",
            "Ytram", "Anna", "Racecar", "Deified"
        };

        for (int index = 0; index < names.length; index+=1) {
            String name = names[index];
            String[] partsOfName = name.split("\\s+");
            String firstName = partsOfName[0];
            String lastName = partsOfName[2];
            String middleInitialAndPeriod = partsOfName[1];

            String period = middleInitialAndPeriod.substring(1);

            assertEquals(".", period);
            assertTrue(Character.isUpperCase(middleInitialAndPeriod.charAt(0)));
            assertEquals(expectedFirstNames[index], firstName);
            assertEquals(expectedLastNames[index], lastName);
        }
    }
}