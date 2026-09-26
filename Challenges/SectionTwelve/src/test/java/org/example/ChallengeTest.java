package org.example;

import org.ajbrown.namemachine.NameGenerator;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChallengeTest {

    private List<NewStudent> students;
    private NewQueryList<NewStudent> queryList;

    @BeforeEach
    public void setUp() {
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
        students = new ArrayList<>();
        Random random = new Random();
        int max = 2;
        int min = 1;
        for (int index = 0; index < 25; index+=1) {
            int randomInt = random.nextInt((max - min) + 1) + min;
            if (randomInt == 1) {
                students.add(new NewStudent());
            } else {
                students.add(new NewLPAStudent());
            }
        }
    }
}
