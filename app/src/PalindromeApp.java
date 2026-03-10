import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeApp {

    // Stack-based palindrome
    public static boolean stackPalindrome(String text) {
        Stack<Character> stack = new Stack<>();
        for (char ch : text.toCharArray()) stack.push(ch);
        for (char ch : text.toCharArray()) {
            if (ch != stack.pop()) return false;
        }
        return true;
    }

    // Deque-based palindrome
    public static boolean dequePalindrome(String text) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : text.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    // Two-pointer palindrome
    public static boolean twoPointerPalindrome(String text) {
        int start = 0, end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Stack-based timing
        long startTime = System.nanoTime();
        boolean stackResult = stackPalindrome(input);
        long endTime = System.nanoTime();
        long stackTime = endTime - startTime;

        // Deque-based timing
        startTime = System.nanoTime();
        boolean dequeResult = dequePalindrome(input);
        endTime = System.nanoTime();
        long dequeTime = endTime - startTime;

        // Two-pointer timing
        startTime = System.nanoTime();
        boolean twoPointerResult = twoPointerPalindrome(input);
        endTime = System.nanoTime();
        long twoPointerTime = endTime - startTime;

        System.out.println("\nPalindrome Results:");
        System.out.println("Stack-based: " + stackResult + ", Time: " + stackTime + " ns");
        System.out.println("Deque-based: " + dequeResult + ", Time: " + dequeTime + " ns");
        System.out.println("Two-pointer: " + twoPointerResult + ", Time: " + twoPointerTime + " ns");

        scanner.close();
    }
}