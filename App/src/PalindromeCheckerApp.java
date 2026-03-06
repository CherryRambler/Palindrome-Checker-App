import java.util.Scanner;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "deified";

        char[] charArray = input.toCharArray();

        boolean isPalindrome = true;


        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {

            if (charArray[left] != charArray[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        if (isPalindrome) {
            System.out.println("'" + input + "' is  a palindrome.");
        } else {
            System.out.println("'" + input + "' is not a palindrome.");
        }
    }
}
