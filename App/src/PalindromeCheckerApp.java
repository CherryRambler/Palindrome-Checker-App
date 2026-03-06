import java.util.*;

interface PalindromeStrategy {
    boolean isPalindrome(String text);
}

class StackStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String text) {

        Stack<Character> stack = new Stack<>();

        for (char ch : text.toCharArray()) {
            stack.push(ch);
        }

        String reversed = "";

        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return text.equals(reversed);
    }
}

class DequeStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String text) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : text.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {

            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

class PalindromeChecker {

    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String text) {
        return strategy.isPalindrome(text);
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        System.out.println("Choose Palindrome Strategy");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");

        int choice = sc.nextInt();

        PalindromeChecker checker = new PalindromeChecker();

        if (choice == 1) {
            checker.setStrategy(new StackStrategy());
        }
        else if (choice == 2) {
            checker.setStrategy(new DequeStrategy());
        }
        else {
            System.out.println("Invalid Choice");
            return;
        }

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("The string is a Palindrome");
        } else {
            System.out.println("The string is NOT a Palindrome");
        }

        sc.close();
    }
}