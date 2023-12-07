//Dallas Lawson
//Professor Bowman
//December 6, 2023
//Final


import java.util.Scanner;

class BankDetails {
    private String accountnum;
    private String name;
    private String accounttype;
    private long balance;
    Scanner sc = new Scanner(System.in);

    public void openAccount() {  
        System.out.print("Enter Account Number: ");
        accountnum = sc.next();
        System.out.print("Enter Account Type: ");
        accounttype = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter Balance: ");
        balance = sc.nextLong();
    }

    public void showAccount() {
        System.out.println("Name of account holder: " + name);
        System.out.println("Account number: " + accountnum);
        System.out.println("Account type: " + accounttype);
        System.out.println("Balance: " + balance);
    }

    public void deposit() {
        long amount;
        System.out.println("Enter the amount you'd like to deposit: ");
        amount = sc.nextLong();
        balance = balance + amount;
    }

    public void withdrawal() {
        long amount;
        System.out.println("Enter the amount you'd like to withdraw: ");
        amount = sc.nextLong();
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Balance after withdrawal: " + balance);
        } else {
            System.out.println("Your balance is less than " + amount + "\tTry another amount.");
        }
    }

    public boolean search(String ac_no) {
        if (accountnum.equals(ac_no)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}
public class Final {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many number of customers do you want to input? ");
        int n = sc.nextInt();
        BankDetails C[] = new BankDetails[n];
        for (int i = 0; i < C.length; i++) {
            C[i] = new BankDetails();
            C[i].openAccount();
        }

        int ch;
        do {
            System.out.println("\n ***Banking System Application***");
            System.out.println("1. Display Account Details\n 2. Search By Account Number\n 3. Deposit\n 4. Withdraw\n 5. Exit ");
            System.out.println("Enter your choice: ");
            ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        for (int i = 0; i < C.length; i++) {
                            C[i].showAccount();
                        }
                        break;
                    case 2:
                        System.out.print("Enter the account number you want to search: ");
                        String ac_no = sc.next();
                        boolean found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(ac_no);
                            if (found) {
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Account doesn't exist.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter your account number: ");
                        ac_no = sc.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(ac_no);
                            if (found) {
                                C[i].deposit();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Account doesn't exist.");
                        }
                        break;
                    case 4:
                        System.out.print("Enter Account Number: ");
                        ac_no = sc.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(ac_no);
                            if (found) {
                                C[i].withdrawal();
                                break;
                            }
                        }
                        if (!found) {  
                            System.out.println("Account doesn't exist.");
                        }
                        break;
                    case 5:
                        System.out.println("Goodbye.");
                        break;
                }
            }
            while (ch != 5);
        }
    }