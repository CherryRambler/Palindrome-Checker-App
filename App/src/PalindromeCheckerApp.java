import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PalindromeCheckerApp {
    public static boolean isPalindromeRecursive(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }


        String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();


        if (cleanedStr.charAt(0) != cleanedStr.charAt(cleanedStr.length() - 1)) {
            return false;
        }


        return isPalindromeRecursive(cleanedStr.substring(1, cleanedStr.length() - 1));
    }

    public static void main(String[] args) {
        String test1 = "madam";
        String test2 = "racecar";
        String test3 = "A man, a plan, a canal, Panama"; // Case & punctuation test
        String test4 = "hello";

        System.out.println("Testing \"" + test1 + "\": " + isPalindromeRecursive(test1));
        System.out.println("Testing \"" + test2 + "\": " + isPalindromeRecursive(test2));
        System.out.println("Testing \"" + test3 + "\": " + isPalindromeRecursive(test3));
        System.out.println("Testing \"" + test4 + "\": " + isPalindromeRecursive(test4));
    }
}
