import java.util.*;

public class PalindromeCheckerApp {

    public static long measurePerformance(PalindromeChecker checker, String text) {
        long startTime = System.nanoTime();
        checker.isPalindrome(text);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        String testString = "A man, a plan, a canal, Panama";
        String longTestString = "Mr. Owl ate my metal worm? No, Mr. Owl ate my metal worm.";

        System.out.println("--- Palindrome Performance Comparison (UC13) ---");
        System.out.println("Test String 1: \"" + testString + "\"");
        System.out.println("Test String 2: \"" + longTestString + "\"");

        String preparedTestString1 = testString.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String preparedTestString2 = longTestString.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        System.out.println("\n*** Results for Test String 1 (short): ***");
        compareAndDisplay(preparedTestString1);

        System.out.println("\n*** Results for Test String 2 (long): ***");
        compareAndDisplay(preparedTestString2);
    }

    public static void compareAndDisplay(String text) {

        PalindromeChecker twoPointer = new TwoPointerChecker();
        boolean result1 = twoPointer.isPalindrome(text);
        long timeTwoPointer = measurePerformance(twoPointer, text);
        System.out.printf("Two-Pointer Approach: %b | %d nanoseconds\n", result1, timeTwoPointer);

        PalindromeChecker stringBuilder = new StringBuilderChecker();
        boolean result2 = stringBuilder.isPalindrome(text);
        long timeStringBuilder = measurePerformance(stringBuilder, text);
        System.out.printf("StringBuilder Approach: %b | %d nanoseconds\n", result2, timeStringBuilder);

        PalindromeChecker recursive = new RecursiveChecker();
        boolean result3 = recursive.isPalindrome(text);
        long timeRecursive = measurePerformance(recursive, text);
        System.out.printf("Recursive Approach: %b | %d nanoseconds\n", result3, timeRecursive);
    }
}

interface PalindromeChecker {
    boolean isPalindrome(String s);
}

class TwoPointerChecker implements PalindromeChecker {
    @Override
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

class StringBuilderChecker implements PalindromeChecker {
    @Override
    public boolean isPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }
}

class RecursiveChecker implements PalindromeChecker {
    @Override
    public boolean isPalindrome(String s) {
        return checkRecursive(s, 0, s.length() - 1);
    }

    private boolean checkRecursive(String s, int left, int right) {
        if (left >= right)
            return true;

        if (s.charAt(left) != s.charAt(right))
            return false;

        return checkRecursive(s, left + 1, right - 1);
    }
}