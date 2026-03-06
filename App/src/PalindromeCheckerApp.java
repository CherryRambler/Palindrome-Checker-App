import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check for palindrome: ");
        String originalInput = scanner.nextLine();

        String normalizedString = originalInput.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < normalizedString.length(); i++) {
            stack.push(normalizedString.charAt(i));
        }

        boolean isPalindrome = true;
        for (int i = 0; i < normalizedString.length(); i++) {
            char poppedChar = stack.pop();

            if (poppedChar != normalizedString.charAt(i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Result: \"" + originalInput + "\" is a Palindrome.");
        } else {
            System.out.println("Result: \"" + originalInput + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }
}