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
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited Rs." + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount){
        if (amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Successfully withdrew Rs." + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }
}

class ATM{
    private BankAccount account;

    public ATM(BankAccount account){
        this.account = account;
    }

    public void checkBalance(){
        System.out.println("Current balance: Rs." + account.getBalance());
    }

    public void deposit(double amount){
        account.deposit(amount);
    }

    public void withdraw(double amount){
        account.withdraw(amount);
    }

    public void showMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do{
            System.out.println("\n ******ATM Menu******");
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("\n Choose an option: ");
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    checkBalance();
                    break;

                case 2:
                    System.out.print("\n Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("\n Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("\n Thank you for using the ATM. GOODBYE!!!");
                    break;
                default:
                    System.out.println("\n Invalid option. PLEASE TRY AGAIN.");
            }
        } 
        while (choice != 4);

        scanner.close();
    }
}

public class main{
    public static void main(String[] args){
        BankAccount account = new BankAccount(500000.0); 
        ATM atm = new ATM(account);
        atm.showMenu();
    }
}
