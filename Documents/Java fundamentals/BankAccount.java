public class BankAccount {

    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;

        if (initialBalance < 0) {
            this.balance = 0.0;
            System.out.println("Warning: Initial balance cannot be negative.");
        } else {
            this.balance = initialBalance;
        }
    }

    
    public String getAccountNumber() {
        return accountNumber;
    }

    
    public String getAccountHolderName() {
        return accountHolderName;
    }

    
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {

        if (amount > 0) {
            balance = balance + amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {

        if (amount > 0 && balance >= amount) {
            balance = balance - amount;
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public double calculateLoan() {

        if (balance < 10000) {
            return balance * 0.10;
        } else if (balance >= 11000 && balance <= 60000) {
            return balance * 0.25;
        } else {
            return balance * 0.30;
        }
    }

    public void displayAccountDetails() {

        System.out.println("\n===== ACCOUNT DETAILS =====");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.printf("Balance: $%.2f%n", balance);
        System.out.printf("Available Loan: $%.2f%n", calculateLoan());
        System.out.println("===========================");
    }

    public static void main(String[] args) {

        BankAccount account1 =
                new BankAccount("ACC001", "Grace", 8000);

        BankAccount account2 =
                new BankAccount("ACC002", "Alice", 25000);

        BankAccount account3 =
                new BankAccount("ACC003", "John", 70000);

        account1.deposit(1000);
        account2.withdraw(5000);

        account1.displayAccountDetails();
        account2.displayAccountDetails();
        account3.displayAccountDetails();
    }
}