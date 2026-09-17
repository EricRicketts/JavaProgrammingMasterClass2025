package org.example;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChallengeTest {

    private List<NewStudent> students;
    private NewQueryList<NewStudent> queryList;

    @BeforeEach
    public void setUp() {
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
