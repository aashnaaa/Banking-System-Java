import java.util.Scanner;

public class BankingSystemV1 {
    // Hardcoded customer credentials
    private static final String BANK_ACCOUNT_NO = "1234567890";
    private static final String PASSWORD = "password";
    public static String getBankAccountNo() {
        return BANK_ACCOUNT_NO;
    }

    public static String getPassword() {
        return PASSWORD;
    }

    private static double balance = 1000; // Initial balance for demonstration

    // Main method to run the banking system
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to Indian Bank's Version 1 Banking System!");

        // Ask for credentials
        System.out.print("Enter Bank Account Number: ");
        String enteredAccountNo = scanner.nextLine();

        System.out.print("Enter Password: ");
        String enteredPassword = scanner.nextLine();

        // Verify credentials
        if (verifyCredentials(enteredAccountNo, enteredPassword)) {
            System.out.println("Credentials verified successfully.");

            // Display options menu
            displayOptionsMenu(scanner);
        } else {
            System.out.println("Invalid credentials. Access denied.");
        }

        // Close scanner
        scanner.close();
    }

    // Method to verify customer credentials
    private static boolean verifyCredentials(String accountNo, String password) {
        return accountNo.equals(BANK_ACCOUNT_NO) && password.equals(PASSWORD);
    }

    // Method to display options menu and handle user choices
    private static void displayOptionsMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdrawal");
            System.out.println("3. Transfer");
            System.out.println("4. OTP generation");
            System.out.println("5. Exit");

            // Read user choice
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            // Process user choice
            switch (choice) {
                case 1:
                    System.out.println("You chose Deposit.");
                    deposit(scanner);
                    break;
                case 2:
                    System.out.println("You chose Withdrawal.");
                    withdrawal(scanner);
                    break;
                case 3:
                    System.out.println("You chose Transfer.");
                    transfer(scanner);
                    break;
                case 4:
                    System.out.println("You chose OTP generation.");
                    generateOTP();
                    break;
                case 5:
                    System.out.println("Exiting the Banking System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        }
    }

    // Method to handle deposit operation
    private static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount. Deposit amount must be greater than zero.");
            return;
        }
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    // Method to handle withdrawal operation
    private static void withdrawal(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount <= 0 || amount > balance) {
            System.out.println("Invalid amount or insufficient balance.");
            return;
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Current balance: " + balance);
    }

    // Method to handle transfer operation
    private static void transfer(Scanner scanner) {
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        if (amount <= 0 || amount > balance) {
            System.out.println("Invalid amount or insufficient balance.");
            return;
        }
        System.out.print("Enter recipient's bank account number: ");
        String recipientAccount = scanner.next(); // Simulating recipient account input
        System.out.println("Transfer of " + amount + " to account " + recipientAccount + " successful.");
        balance -= amount;
        System.out.println("Current balance: " + balance);
    }

    // Method to handle OTP generation (dummy implementation for demonstration)
    private static void generateOTP() {
        int otp = (int) (Math.random() * 1000000);
        System.out.println("Generated OTP: " + otp);
    }
}