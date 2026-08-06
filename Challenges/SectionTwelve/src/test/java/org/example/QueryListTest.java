package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QueryListTest {

    private QueryList<FourthStudent> firstQueryList;
    private QueryList<LPAStudent> secondQueryList;
    private List<FourthStudent> fourthStudents;
    private List<LPAStudent> lpaStudents;

    @BeforeEach
    public void setUp() {
        fourthStudents = new ArrayList<>();
        for (int index = 0; index < 50; index+=1) {
            fourthStudents.add(new FourthStudent());
        }
        firstQueryList = new QueryList<>(fourthStudents);

        lpaStudents = new ArrayList<>();
        for (int index = 0; index < 50; index+=1) {
            lpaStudents.add(new LPAStudent());
        }
        secondQueryList = new QueryList<>(lpaStudents);
    }

    @Test
    public void testQueryOfFirstStudentList() {
        List<FourthStudent> matches = firstQueryList.getMatches("Course", "Python");
        assertFalse(matches.isEmpty());
        for (FourthStudent match : matches) {
            assertEquals("Python", match.getCourse());
        }
    }

    @Test
    public void testQueryOfFirstStudentListStaticMethod() {
        List<FourthStudent> matches =
            QueryList.<FourthStudent>getMatches(fourthStudents, "Course", "Java");
        assertFalse(matches.isEmpty());
        for (FourthStudent match : matches) {
            assertEquals("Java", match.getCourse());
        }
    }

    @Test
    public void testQueryOfSecondStudentList() {
        List<LPAStudent> matches = secondQueryList.getMatches("YearStarted", "2020");
        assertFalse(matches.isEmpty());
        for (LPAStudent match : matches) {
            assertEquals(2020, match.getYearStarted());
        }
    }

    @Test
    public void testQueryOfSecondStudentListStaticMethod() {
        // This is not the best match, it just matches the first name.  To match the first name and
        // last name initial, I would have to cycle through the first name and all the last name initial
        // possibilities, which would take more time than I am willing to spend now.
        List<LPAStudent> matches =
            QueryList.<LPAStudent>getMatches(lpaStudents, "Name", "John");
        assertFalse(matches.isEmpty());
    }
}
