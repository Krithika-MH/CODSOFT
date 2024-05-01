import java.util.Scanner;

class BankAccount {
    Scanner sc = new Scanner(System.in);
    public String name, acc_no, username, pwd, trans_his = "";
    public int trans;
    public float bal = 0.0f;

    // Constructor to initialize bank account properties
    BankAccount() {
        name = "";
        acc_no = "";
        username = "";
        pwd = "";
        trans_his = "";
        trans = 0;
        bal = 10000.0f; // Setting initial balance if the account to Rs. 10000
    }

    // Method to register a new user
    public void userRegistration() {
        System.out.println("\t\tCUSTOMER REGISTRATION");
        System.out.println("Enter your name : ");
        this.name = sc.nextLine();
        System.out.println("Enter your account number : ");
        this.acc_no = sc.nextLine();
        System.out.println("Enter your Username : ");
        this.username = sc.nextLine();
        System.out.println("Enter your password : ");
        this.pwd = sc.nextLine();
        System.out.println("REGISTRATION SUCCESSFUL!! ");
    }

    // Method to login to the bank account
    public boolean login() {
        boolean isLogin = false;
        while (!isLogin) {
            String un, pass;
            System.out.println("\tCUSTOMER LOGIN ");
            System.out.println("Enter your Username : ");
            un = sc.next();
            if (un.equals(username)) {
                System.out.println("Enter the password : ");
                pass = sc.next();
                if (pass.equals(pwd)) {
                    System.out.println("LOGIN SUCCESSFUL!");
                    isLogin = true;
                } else {
                    System.out.println("Invalid Password!");
                }
            } else {
                System.out.println("User does not exist");
            }
        }
        return isLogin;
    }

    // Method to withdraw money from the account
    public void withdraw(float amount) {
        try {
            if (amount < bal) {
                bal -= amount;
                System.out.println("Rs." + amount + " Withdrawn Successfully");
                trans++;
                trans_his += "\nRs. " + amount + " withdrawn";
            } else {
                System.out.println("Insufficient balance");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to deposit money into the account
    public void deposit(float amount) {
        try {
            bal += amount;
            System.out.println("Rs." + amount + " Deposited Successfully");
            trans++;
            trans_his += "\nRs. " + amount + " deposited";
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to check the current balance of the account
    public void checkBalance() {
        System.out.println("Current Account Balance is Rs. " + bal);
    }
}

class ATM {
    // Method to perform various transactions in the ATM
    public static void transactions(BankAccount b, Scanner sc) {
        b.login();
        System.out.println("\n1.Withdraw\n2.Deposit\n3.Check Balance\n4.Exit\nChoose the option ");
        int choice = sc.nextInt();
        float amt = 0.0f;
        switch (choice) {
            case 1:
                System.out.println("Enter the amount to withdraw : ");
                amt = sc.nextFloat();
                b.withdraw(amt);
                break;
            case 2:
                System.out.println("Enter the amount to deposit : ");
                amt = sc.nextFloat();
                b.deposit(amt);
                break;
            case 3:
                b.checkBalance();
                System.out.println("Do you want to view transaction history (yes-1/No -0): ");
                int c = sc.nextInt();
                if (c == 1) {
                    System.out.println("\n\t\tCUSTOMER TRANSACTION DETAILS\n");
                    System.out.println("Name : " + b.name);
                    System.out.println("Account Number : " + b.acc_no);
                    System.out.println("The Number of Transactions : " + b.trans);
                    System.out.println("\nTransactions History : " + b.trans_his);
                }
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice !");
                break;
        }
    }

    // Main method to start the ATM
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        BankAccount b = new BankAccount();
        while (true) {
            System.out.println("Do you have an account (Yes-1/No-0) : ");
            int ch = sc.nextInt();

            if (ch == 1) {
                transactions(b, sc);
            } else if (ch == 0) {
                b.userRegistration();
                transactions(b, sc);
            } else {
                System.out.println("Invalid Choice !");
            }
        }
    }
}
