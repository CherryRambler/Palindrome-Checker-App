import java.util.Scanner;
public class PalindromeCheckerApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Palindrome Checker Management System");
        System.out.print("Enter a string: ");

        String text = scanner.nextLine();
        boolean isPalindrome = true;

        for (int i = 0; i < text.length() / 2; i++) {
            if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(text + " is a palindrome");
        } else {
            System.out.println(text + " is not a palindrome");
        }

        scanner.close();
    }
}
