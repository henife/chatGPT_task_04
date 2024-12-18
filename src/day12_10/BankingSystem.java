package day12_10;

import java.util.ArrayList;
import java.util.Scanner;

public class BankingSystem {
    private String name;
    private String bankAccount;
    private double balance;
    ArrayList<String> transactionHistory;

    public BankingSystem(String name, String bankAccount) {
        this.name = name;
        this.bankAccount = bankAccount;
        this.balance = 0.0;
        transactionHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposit " + amount + " to " + bankAccount);
            System.out.println("Deposited " + amount + " to " + bankAccount);
        } else {
            System.out.println("Cannot deposit " + amount + " to " + bankAccount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            this.balance -= amount;
            transactionHistory.add("Withdraw " + amount + " to " + bankAccount);
            System.out.println("Withdrawn " + amount + " from " + bankAccount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void tranfer(BankingSystem otherBankingSystem, double amount) {
        if (amount > 0 && balance >= amount) {
            withdraw(amount);
            otherBankingSystem.deposit(amount);
            transactionHistory.add("Transfer " + amount + " to " + bankAccount);
            otherBankingSystem.transactionHistory.add("Received " + amount + " from " + bankAccount);
            System.out.println("Transferred " + amount + " to " + otherBankingSystem.getBankAccount());
        }
    }

    public void printTransactionHistory() {
        transactionHistory.forEach(System.out::println);
    }
}

class BankSystem {
    private static ArrayList<BankingSystem> bankSystems = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();

        if(password != null && !password.equals("1234")) {
            System.out.println("Invalid password");
            return;
        }

        while (true) {
            System.out.println("""
                    \t\tWELCOME TO THE BANK OF AMERICA!!!
                    1. Create a new account
                    2. Deposit money
                    3. Withdraw money
                    4. Transfer money
                    5. Check balance
                    6. View transaction history
                    7. Exit
                    enter password
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> createAccount(scanner);
                case 2 -> deposit(scanner);
                case 3 -> withdraw(scanner);
                case 4 -> transfer(scanner);
                case 5 -> checkBalance(scanner);
                case 6 -> viewTransactionHistory(scanner);
                case 7 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public static void createAccount(Scanner scanner) {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter bank account: ");
        String bankAccount = scanner.nextLine();

        BankingSystem bankSystem = new BankingSystem(name, bankAccount);
        bankSystems.add(bankSystem);
        System.out.println("Account created");
    }

    public static BankingSystem getAccount(String BankAccount) {
        for (BankingSystem bankSystem : bankSystems) {
            if (bankSystem.getBankAccount().equals(BankAccount)) {
                return bankSystem;
            }
        }
        System.out.println("Account not found");
        return null;
    }

    public static void deposit(Scanner scanner) {
        System.out.println("Enter the bank account number: ");
        String bankAccount = scanner.nextLine();
        BankingSystem bankSystem = getAccount(bankAccount);

        if (bankSystem != null) {
            System.out.println("please enter deposit amount");
            bankSystem.deposit(scanner.nextDouble());
        }
    }

    public static void withdraw(Scanner scanner) {
        System.out.println("Enter the bank account number: ");
        String bankAccount = scanner.nextLine();
        BankingSystem bankSystem = getAccount(bankAccount);
        if (bankSystem != null) {
            System.out.println("please enter withdraw amount");
            bankSystem.withdraw(scanner.nextDouble());
        }
    }

    public static void transfer(Scanner scanner) {
        System.out.println("Enter your bank account number: ");
        String bankAccount = scanner.nextLine();
        BankingSystem bankSystem = getAccount(bankAccount);
        if (bankSystem != null) {
            System.out.println("please enter target bank account number");
            String otherAccountNumber = scanner.nextLine();
            BankingSystem otherBankSystem = getAccount(otherAccountNumber);
            if (otherBankSystem != null) {
                System.out.println("enter the amount you would like to transfer");
                double amount = scanner.nextDouble();
                bankSystem.tranfer(otherBankSystem, amount);


            }

        }
    }

    public static void checkBalance(Scanner scanner) {
        System.out.println("Enter account number to check balance: ");
        String accountNumber = scanner.nextLine();
        BankingSystem account = getAccount(accountNumber);

        if (account != null) {
            System.out.println("Balance for account " + accountNumber + ": $" + account.getBalance());
        }
    }

    public static void viewTransactionHistory(Scanner scanner) {
        System.out.println("Enter account number to view transaction history: ");
        String accountNumber = scanner.nextLine();
        BankingSystem account = getAccount(accountNumber);

        if (account != null) {
            account.printTransactionHistory();
        }
    }
}
