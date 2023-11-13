import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (bankAccount.withdraw(amount)) {
                System.out.println("Withdrawal successful. Remaining balance: Rs." + bankAccount.getBalance());
            } else {
                System.out.println("Insufficient funds. Withdrawal failed.");
            }
        } else {
            System.out.println("Invalid amount for withdrawal. Please enter a positive value.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            bankAccount.deposit(amount);
            System.out.println("Deposit successful. New balance: Rs." + bankAccount.getBalance());
        } else {
            System.out.println("Invalid amount for deposit. Please enter a positive value.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: Rs." + bankAccount.getBalance());
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance: Rs.");
        double initialBalance = scanner.nextDouble();

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);

        while (true) {
            displayMenu();

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: Rs.");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: Rs.");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
}
