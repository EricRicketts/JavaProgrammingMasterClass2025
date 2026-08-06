package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QueryListTest {

    private QueryList<FourthStudent> firstQueryList;
    private QueryList<LPAStudent> secondQueryList;
    private List<QueryItem> fourthStudents;
    private List<QueryItem> lpaStudents;

    @BeforeEach
    public void setUp() {
        List<FourthStudent> fourthStudents = new ArrayList<>();
        for (int index = 0; index < 50; index+=1) {
            fourthStudents.add(new FourthStudent());
        }
        firstQueryList = new QueryList<>(fourthStudents);

        List<LPAStudent> lpaStudents = new ArrayList<>();
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
    public void testQueryOfSecondStudentList() {
        List<LPAStudent> matches = secondQueryList.getMatches("YearStarted", "2020");
        assertFalse(matches.isEmpty());
        for (LPAStudent match : matches) {
            assertEquals(2020, match.getYearStarted());
        }
    }
}
