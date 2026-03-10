import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

// Strategy interface
interface PalindromeStrategy {
    boolean isPalindrome(String text);
}

// Stack-based palindrome strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        Stack<Character> stack = new Stack<>();
        for (char ch : text.toCharArray()) {
            stack.push(ch);
        }
        for (char ch : text.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Deque-based palindrome strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
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

// Context class to inject strategy
class PalindromeContext {
    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String text) {
        return strategy.isPalindrome(text);
    }
}

// Main class
public class PalindromeApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Choose Palindrome Strategy:");
        System.out.println("1. Stack-based");
        System.out.println("2. Deque-based");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else if (choice == 2) {
            strategy = new DequeStrategy();
        } else {
            System.out.println("Invalid choice. Defaulting to Stack strategy.");
            strategy = new StackStrategy();
        }

        // Inject strategy
        PalindromeContext context = new PalindromeContext(strategy);

        if (context.executeStrategy(input)) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}