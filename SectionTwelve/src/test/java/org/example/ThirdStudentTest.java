package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ThirdStudentTest {

    private List<ThirdStudent> thirdStudents;
    private QueryList<ThirdStudent> queryList;
    private List<ThirdStudent> expected, result;

    @BeforeEach
    public void setUp() {
        thirdStudents = new ArrayList<>(
            List.of(
                new ThirdStudent(
                    "Doe",
                    "John",
                    "Perl",
                    1999
                ),
                new ThirdStudent(
                    "Doe",
                    "Jane",
                    "English Literature",
                    2000
                ),
                new ThirdStudent(
                    "Smith",
                    "Carlton",
                    "Physics",
                    2012
                ),
                new ThirdStudent(
                    "Smith",
                    "Christine",
                    "American Literature",
                    2011
                ),
                new ThirdStudent(
                    "Taub",
                    "Alfred",
                        "Chemistry",
                    2008
                ),
                new ThirdStudent(
                    "Jones",
                    "Meredith",
                    "Political Science",
                    2021
                ),
                new ThirdStudent(
                    "Miller",
                    "David",
                    "Finance",
                    2024
                ),
                new ThirdStudent(
                    "Hargess",
                    "Susan",
                    "Art",
                    2009
                ),
                new ThirdStudent(
                    "Kay",
                    "Alan",
                    "Smalltalk",
                    2007
                ),
                new ThirdStudent(
                    "Oneil",
                    "Tatum",
                    "Theater",
                    2023
                )
            )
        );

        queryList = new QueryList<>(thirdStudents);
    }

    @Test
    public void testGetStudentsByFirstName() {
        expected = new ArrayList<>(
                List.of(
                new ThirdStudent(
                    "Smith",
                    "Carlton",
                    "Physics",
                    2012
                ),
                new ThirdStudent(
                    "Smith",
                    "Christine",
                    "American Literature",
                    2011
                )
            )
        );

        result =
            queryList.getMatches("lastName", "Smith");
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    public void testGetStudentsByLastName() {
        expected = new ArrayList<>(
                List.of(new ThirdStudent(
                "Oneil",
                "Tatum",
                "Theater",
                2023
                )
            )
        );

        result = queryList.getMatches("firstName", "Tatum");
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    public void testGetStudentsByCourse() {
        expected = new ArrayList<>(
            List.of(new ThirdStudent(
                    "Miller",
                    "David",
                    "Finance",
                    2024
                )
            )
        );

        result = queryList.getMatches("course", "finance");
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    public void testGetStudentsByYearStarted() {
        expected = new ArrayList<>(
            List.of(
                new ThirdStudent(
                    "Hargess",
                    "Susan",
                    "Art",
                    2009
                )
            )
        );

        result = queryList.getMatches("yearstarted", "2009");
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }
}
