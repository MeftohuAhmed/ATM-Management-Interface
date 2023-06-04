import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu {
    private Scanner menuInput;
    private DecimalFormat moneyFormat;
    private HashMap<Integer, Account> accountData;

    public OptionMenu() {
        menuInput = new Scanner(System.in);
        moneyFormat = new DecimalFormat("'$'###,##0.00");
        accountData = new HashMap<>();
    }

    public void performLogin() throws IOException {
        boolean loggedIn = false;
        int customerNumber = 0;
        int pinNumber = 0;

        while (!loggedIn) {
            try {
                System.out.print("\nEnter your customer number: ");
                customerNumber = menuInput.nextInt();
                System.out.print("Enter your PIN number: ");
                pinNumber = menuInput.nextInt();

                Iterator<Map.Entry<Integer, Account>> iterator = accountData.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Integer, Account> entry = iterator.next();
                    Account account = entry.getValue();
                    if (entry.getKey() == customerNumber && pinNumber == account.getPinNumber()) {
                        performAccountAction(account);
                        loggedIn = true;
                        break;
                    }
                }

                if (!loggedIn) {
                    System.out.println("\nWrong Customer Number or Pin Number");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Character(s). Only Numbers.");
                menuInput.next();
            }
        }
    }

    public void performAccountAction(Account account) {
        boolean end = false;

        while (!end) {
            try {
                System.out.println("\nSelect the account you want to access:");
                System.out.println(" Type 1 - Checking Account");
                System.out.println(" Type 2 - Savings Account");
                System.out.println(" Type 3 - Exit");
                System.out.print("Choice: ");
                int selection = menuInput.nextInt();

                switch (selection) {
                    case 1:
                        performCheckingAccountAction(account);
                        break;
                    case 2:
                        performSavingAccountAction(account);
                        break;
                    case 3:
                        end = true;
                        break;
                    default:
                        System.out.println("\nInvalid Choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                menuInput.next();
            }
        }
    }

    public void performCheckingAccountAction(Account account) {
        boolean end = false;

        while (!end) {
            try {
                System.out.println("\nChecking Account:");
                System.out.println(" Type 1 - View Balance");
                System.out.println(" Type 2 - Withdraw Funds");
                System.out.println(" Type 3 - Deposit Funds");
                System.out.println(" Type 4 - Transfer Funds");
                System.out.println(" Type 5 - Exit");
                System.out.print("Choice: ");

                int selection = menuInput.nextInt();

                switch (selection) {
                    case 1:
                        System.out.println("\nChecking Account Balance: " + moneyFormat.format(account.getCheckingBalance()));
                        break;
                    case 2:
                        account.performCheckingWithdrawal();
                        break;
                    case 3:
                        account.performCheckingDeposit();
                        break;
                    case 4:
                        account.performTransfer("Checking");
                        break;
                    case 5:
                        end = true;
                        break;
                    default:
                        System.out.println("\nInvalid Choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                menuInput.next();
            }
        }
    }

    public void performSavingAccountAction(Account account) {
        boolean end = false;

        while (!end)

        {
            try {
                System.out.println("\nSavings Account:");
                System.out.println(" Type 1 - View Balance");
                System.out.println(" Type 2 - Withdraw Funds");
                System.out.println(" Type 3 - Deposit Funds");
                System.out.println(" Type 4 - Transfer Funds");
                System.out.println(" Type 5 - Calculate Interest");
                System.out.println(" Type 6 - Exit");
                System.out.print("Choice: ");

                int selection = menuInput.nextInt();

                switch (selection) {
                    case 1:
                        System.out.println("\nSavings Account Balance: " + moneyFormat.format(account.getSavingBalance()));
                        break;
                    case 2:
                        account.performSavingWithdrawal();
                        break;
                    case 3:
                        account.performSavingDeposit();
                        break;
                    case 4:
                        account.performTransfer("Savings");
                        break;
                    case 5:
                        account.calculateInterest();
                        break;
                    case 6:
                        end = true;
                        break;
                    default:
                        System.out.println("\nInvalid Choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                menuInput.next();
            }
        }
    }

    public void createAccount() throws IOException {
        int customerNumber = 0;
        boolean end = false;

        while (!end) {
            try {
                System.out.print("\nEnter your customer number: ");
                customerNumber = menuInput.nextInt();

                Iterator<Map.Entry<Integer, Account>> iterator = accountData.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Integer, Account> entry = iterator.next();
                    if (entry.getKey() == customerNumber) {
                        System.out.println("\nThis customer number is already registered.");
                        return;
                    }
                }
                end = true;
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                menuInput.next();
            }
        }

        System.out.print("Enter PIN to be registered: ");
        int pin = menuInput.nextInt();
        accountData.put(customerNumber, new Account(customerNumber, pin));
        System.out.println("\nYour new account has been successfully registered!");
        System.out.println("Redirecting to login...");
        performLogin();
    }

    public void displayMainMenu() throws IOException {
        accountData.put(952141, new Account(952141, 191904, 1000, 5000));
        accountData.put(123, new Account(123, 123, 20000, 50000));

        boolean end = false;

        while (!end) {
            try {
                System.out.println("\nMain Menu:");
                System.out.println(" Type 1 - Login");
                System.out.println(" Type 2 - Create Account");
                System.out.println(" Type 3 - Exit");
                System.out.print("Choice: ");
                int choice = menuInput.nextInt();

                switch (choice) {
                    case 1:
                        performLogin();
                        end = true;
                        break;
                    case 2:
                        createAccount();
                        end = true;
                        break;
                    case 3:
                        end = true;
                        break;
                    default:
                        System.out.println("\nInvalid Choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                menuInput.next();
            }
        }

        System.out.println("\nThank you for using this ATM.\n");
        menuInput.close();
        System.exit(0);
    }
}
