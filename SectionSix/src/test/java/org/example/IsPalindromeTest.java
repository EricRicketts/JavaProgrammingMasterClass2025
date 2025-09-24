package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IsPalindromeTest {

    public static boolean isPalindrome(int number) {
        int remaining_number = Math.abs(number);
        int palindrome = 0;
        while (remaining_number >= 10) {
            int remainder = remaining_number % 10;
            palindrome = (palindrome + remainder) * 10;
            remaining_number = remaining_number / 10;
        }
        palindrome = (palindrome + remaining_number);
        return palindrome == Math.abs(number);
    }

    @Test
    public void testIsPalindromeFirst() {
        Assertions.assertTrue(isPalindrome(-1221));
    }

    @Test
    public void testIsPalindromeSecond() {
        Assertions.assertTrue(isPalindrome(707));
    }

    @Test
    public void testIsPalindromeThird() {
        Assertions.assertFalse(isPalindrome(11212));
    }

    @Test
    public void testIsPalindromeFourth() {
        Assertions.assertTrue(isPalindrome(1234321));
    }

    @Test
    public void testIsPalindromeFifth() {
        Assertions.assertFalse(isPalindrome(1235698));
    }
}
