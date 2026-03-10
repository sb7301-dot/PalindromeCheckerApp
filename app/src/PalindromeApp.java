import java.util.Scanner;
import java.util.Stack;

public class PalindromeApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Create a PalindromeChecker object
        PalindromeChecker checker = new PalindromeChecker(input);

        // Check palindrome
        if (checker.checkPalindrome()) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}

// PalindromeChecker class encapsulates all logic
class PalindromeChecker {

    private String text;

    // Constructor
    public PalindromeChecker(String text) {
        this.text = text;
    }

    // Method to check palindrome using Stack internally
    public boolean checkPalindrome() {

        if (text == null || text.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }

        // Pop characters and compare with original string
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}
