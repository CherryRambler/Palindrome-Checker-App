import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PalindromeCheckerApp {

    public static class Node {
        char data;
        Node next;
        Node(char d) {
            data = d;
            next = null;
        }
    }

    private Node head;

    public void insert(char data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHalfHead = reverseList(slow.next);
        Node firstHalfPointer = head;
        Node secondHalfPointer = secondHalfHead;
        boolean isPalindrome = true;
        while (secondHalfPointer != null) {
            if (firstHalfPointer.data != secondHalfPointer.data) {
                isPalindrome = false;
                break;
            }
            firstHalfPointer = firstHalfPointer.next;
            secondHalfPointer = secondHalfPointer.next;
        }


        return isPalindrome;
    }

    private Node reverseList(Node headNode) {
        Node prev = null;
        Node current = headNode;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        String testString1 = "madam";
        PalindromeCheckerApp list1 = new PalindromeCheckerApp(); // Corrected class name
        for (char c : testString1.toCharArray()) {
            list1.insert(c);
        }
        System.out.println("String: " + testString1);
        System.out.println("Is Palindrome? " + list1.isPalindrome());
        System.out.println("-" .repeat(20));

        String testString2 = "hello";
        PalindromeCheckerApp list2 = new PalindromeCheckerApp(); // Corrected class name
        for (char c : testString2.toCharArray()) {
            list2.insert(c);
        }
        System.out.println("String: " + testString2);
        System.out.println("Is Palindrome? " + list2.isPalindrome());
        System.out.println("-" .repeat(20));

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string to check for palindrome: ");
            String userInput = scanner.nextLine();

            userInput = userInput.replaceAll("[^a-zA-Z]", "").toLowerCase();

            PalindromeCheckerApp userList = new PalindromeCheckerApp();
            for (char c : userInput.toCharArray()) {
                userList.insert(c);
            }
            System.out.println("Cleaned string: " + userInput);
            System.out.println("Is Palindrome? " + userList.isPalindrome());
        }
    }
}
