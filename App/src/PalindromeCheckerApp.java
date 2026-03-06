import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class PalindromeChecker {

    public boolean checkPalindrome(String str) {
        if (str == null) {
            return false;
        }

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                deque.add(Character.toLowerCase(c));
            }
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.println("--- Palindrome Checker App ---");
        System.out.println("Enter a string to check (or type 'exit' to quit):");

        while (true) {
            System.out.print("Input: ");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Exiting application. Goodbye!");
                break;
            }

            boolean isPalindrome = checker.checkPalindrome(input);

            if (isPalindrome) {
                System.out.println("Result: \"" + input + "\" IS a palindrome.");
            } else {
                System.out.println("Result: \"" + input + "\" IS NOT a palindrome.");
            }
            System.out.println("--------------------------------");
        }

        scanner.close();
    }
}
