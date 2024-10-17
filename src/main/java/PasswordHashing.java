import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Scanner;

public class PasswordHashing {
    public static void main(String[] args) {
        // Create a scanner to read input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a plaintext password
        System.out.print("Enter a plaintext password: ");
        String plaintextPassword = scanner.nextLine();

        // Create a BCryptPasswordEncoder
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Generate the hashed password
        String hashedPassword = passwordEncoder.encode(plaintextPassword);

        // Output the hashed password
        System.out.println("Hashed Password: " + hashedPassword);

        // Close the scanner
        scanner.close();
    }
}
