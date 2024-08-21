import java.util.Scanner;
class Level1TextualPassword {
    private String storedPassword;
    public Level1TextualPassword(String password) {
        this.storedPassword = password;
    }
    public boolean authenticate(String inputPassword) {
        return inputPassword.equals(storedPassword);
    }
}
class Level2GraphicalPassword {
    private int[] storedPattern = {1, 3, 5}; // Predefined graphical pattern (points)
    public boolean authenticate(int[] inputPattern) {
        if (inputPattern.length != storedPattern.length) {
            return false;
        }
        for (int i = 0; i < storedPattern.length; i++) {
            if (inputPattern[i] != storedPattern[i]) {
                return false;
            }
        }
        return true;
    }
}
class Level3BiometricAuthentication {
    public boolean authenticate() {
        // Simulating successful biometric authentication
        return true;
    }
}
public class ThreeLevelPasswordSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Level1TextualPassword level1 = new Level1TextualPassword("SecurePass123");
        System.out.print("Enter your textual password: ");
        String inputPassword = scanner.nextLine();
        if (!level1.authenticate(inputPassword)) {
            System.out.println("Level 1 Authentication Failed. Access Denied.");
            return;
        }
        System.out.println("Level 1 Authentication Passed.");
        Level2GraphicalPassword level2 = new Level2GraphicalPassword();
        System.out.println("Enter the graphical pattern (3 points between 1 and 5): ");
        int[] inputPattern = new int[3];
        for (int i = 0; i < 3; i++) {
            inputPattern[i] = scanner.nextInt();
        }
        if (!level2.authenticate(inputPattern)) {
            System.out.println("Level 2 Authentication Failed. Access Denied.");
            return;
        }
        System.out.println("Level 2 Authentication Passed.");
        Level3BiometricAuthentication level3 = new Level3BiometricAuthentication();
        if (!level3.authenticate()) {
            System.out.println("Level 3 Biometric Authentication Failed. Access Denied.");
            return;
        }
        System.out.println("Level 3 Authentication Passed - Access Granted!");
        System.out.println("Welcome to the secure system!");
        scanner.close();
    }
}
