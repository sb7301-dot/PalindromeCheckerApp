import java.util.Scanner;
public class PalindromeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String input = scanner.nextLine();
        input = input.replaceAll("\\s+", "").toLowerCase();
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        if (input.equals(reversed)) {
            System.out.println("The input is a palindrome.");
        } else {
            System.out.println("The input is NOT a palindrome.");
        }
        scanner.close();
    }
}