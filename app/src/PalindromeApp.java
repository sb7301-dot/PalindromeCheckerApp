import java.util.Scanner;

public class PalindromeApp {

    // Method to check palindrome
    public static boolean isPalindrome(String str) {

        // Normalize string: remove spaces and convert to lowercase
        String normalized = str.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = normalized.length() - 1;

        // Two-pointer comparison
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("The given string is a Palindrome (ignoring case and spaces).");
        } else {
            System.out.println("The given string is NOT a Palindrome (ignoring case and spaces).");
        }

        scanner.close();
    }
}
