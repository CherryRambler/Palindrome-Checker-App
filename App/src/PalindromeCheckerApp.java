import java.util.Scanner;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String originalString = scanner.nextLine();

        String reversedString = "";


        for (int i = originalString.length() - 1; i >= 0; i--) {
            reversedString += originalString.charAt(i);
        }


        boolean isPalindrome = originalString.equals(reversedString);

        System.out.println("Original String: " + originalString);
        System.out.println("Reversed String: " + reversedString);

        if (isPalindrome) {
            System.out.println("Result: The given string IS a palindrome.");
        } else {
            System.out.println("Result: The given string IS NOT a palindrome.");
        }

        scanner.close();
    }
}