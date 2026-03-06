import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PalindromeCheckerApp {

    public static boolean isPalindromeDeque(String str) {
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();
        for (char c : cleanStr.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            char first = deque.removeFirst();
            char last = deque.removeLast();

            if (first != last) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Palindrome Checker App (UC7) - Deque Implementation");
        System.out.print("Enter any string to check: ");
        String inputString = in.nextLine();

        if (isPalindromeDeque(inputString)) {
            System.out.println("\"" + inputString + "\" is a palindrome.");
        } else {
            System.out.println("\"" + inputString + "\" is not a palindrome.");
        }

        String testStr = "A man, a plan, a canal: Panama";
        System.out.println("\nTesting another example: \"" + testStr + "\"");
        if (isPalindromeDeque(testStr)) {
            System.out.println("\"" + testStr + "\" is a palindrome: " + isPalindromeDeque(testStr));
        }

        in.close();
    }
}
