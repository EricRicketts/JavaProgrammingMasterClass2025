package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LPAStudentTest {
    ArrayList<LPAStudent> lpaStudents = new ArrayList<>();
    String expected, result;

    @BeforeEach
    public void setUp() {
        for (int i = 0; i < 5; i++) {
            LPAStudent s = new LPAStudent("S87600" + i,
                    switch (i) {
                        case 0 -> "Betty";
                        case 1 -> "Bernice";
                        case 2 -> "Todd";
                        case 3 -> "Holden";
                        case 4 -> "Lulu";
                        default -> "Anonymous";
                    },
                    switch (i) {
                        case 0 -> "6/1/1985";
                        case 1 -> "7/1/1985";
                        case 2 -> "8/1/1985";
                        case 3 -> "9/1/1985";
                        case 4 -> "10/1/1985";
                        default -> "Default Birth Date";
                    },
                    "Java Masterclass"
            );
            lpaStudents.add(s);
        }
    }

    @Test
    public void testLPAStudentsCreated() {
        assertEquals(5, lpaStudents.size());
    }

    @Test
    public void testLastLPAStudentIdGetter() {
        // A very important characteristic of records, they cannot have their
        // individual fields modified after instantiation as can a POJO.
        assertEquals("S876004", lpaStudents.getLast().id());
    }

    @Test
    public void testPrintingOutAnLPAStudentRecord() {
        expected =
                "LPAStudent[id=S876002, name=Todd, dateOfBirth=8/1/1985, " +
                        "classList=Java Masterclass]";
        result = lpaStudents.get(2).toString();
        assertEquals(expected, result);
    }

}
