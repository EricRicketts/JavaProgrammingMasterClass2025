package org.example;

import org.ajbrown.namemachine.Name;
import org.ajbrown.namemachine.NameGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChallengeTest {

    private QueryListChallenge<NewLPAStudent> queryList;
    private List<NewLPAStudent> lpaStudents;

    @BeforeEach
    public void setUp() {
        queryList = new QueryListChallenge<>();
        lpaStudents = new ArrayList<>();
        NameGenerator nameGenerator = new NameGenerator();
        int lowerIdBound = 111111;
        int upperIdBound = 999999;
        int lowerBoundYearStarted = 2000;
        int upperBoundYearStarted = 2025;
        int lowerIndexBoundCourses = 0;
        int upperIndexBoundCourses = 24;
        List<String> courses = List.of(
            "C", "C++", "Pascal", "Java", "Python",
            "Javascript", "Typescript", "Ruby", "Rust", "C#",
            "SQL", "R", "Fortran", "Basic", "PHP",
            "Assembly", "Swift", "Objective-C", "Kotlin", "Go",
            "Julia", "Perl", "Raku", "Caml", "Lua"
        );
        Random random = new Random();
        for (int index = 0; index < 25; index+=1) {
            int randomId = lowerIdBound + random.nextInt(upperIdBound - lowerIdBound + 1);
            int randomYear = lowerBoundYearStarted +
                random.nextInt(upperBoundYearStarted - lowerBoundYearStarted + 1);
            int indexIntoCourses = lowerIndexBoundCourses +
                random.nextInt(upperIndexBoundCourses - lowerIndexBoundCourses + 1);
            String course = courses.get(indexIntoCourses);
            Name name = nameGenerator.generateName();
            lpaStudents.add(
                new NewLPAStudent(name.toString(), course, randomId, randomYear)
            );
        }
    }

    @Test
    public void testSortingById() {
        queryList.addAll(lpaStudents);
        queryList.sort(Comparator.naturalOrder());
        for (int index = 0; index < queryList.size() - 1; index+=1) {
            var currentStudent = queryList.get(index);
            var nextStudent = queryList.get(index + 1);
            assertTrue(currentStudent.getId() < nextStudent.getId());
        }
    }

    @Test
    public void testFilterByPercentComplete() {
        queryList.addAll(lpaStudents);
        var matches = queryList.getMatches("PercentComplete", "50");
        for (var match : matches) {
            BigDecimal upperBound = new BigDecimal("50.00");
            assertTrue(
                ((NewLPAStudent) match).getPercentComplete().compareTo(upperBound) <= 0
            );
        }
    }

    @Test
    public void testFilterByComparatorWithNaturalOrder() {
        QueryListChallenge<NewLPAStudent> lpaQueryList =
            new QueryListChallenge<>(lpaStudents);
        var matches = lpaQueryList.getMatches("PercentComplete", "50");
        matches.sort(Comparator.naturalOrder());
        for (int index = 0; index < matches.size() - 1; index+=1) {
            NewLPAStudent currentMatch = matches.get(index);
            NewLPAStudent nextMatch = matches.get(index + 1);
            int compareResult = currentMatch.compareTo(nextMatch);
            assertTrue(compareResult <= 0);
        }
    }

    @Test
    public void testFilterByLPAStudentComparator() {
        QueryListChallenge<NewLPAStudent> lpaQueryList =
            new QueryListChallenge<>(lpaStudents);
        var matches = lpaQueryList.getMatches("PercentComplete", "50");
        matches.sort(new NewLPAStudentComparator());
        for (int index = 0; index < matches.size() - 1; index+=1) {
            BigDecimal currentMatch = matches.get(index).getPercentComplete();
            BigDecimal nextMatch = matches.get(index + 1).getPercentComplete();
            int compareResult = currentMatch.compareTo(nextMatch);
            assertTrue(compareResult <= 0);
        }
    }
}
