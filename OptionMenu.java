import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The OptionMenu class represents the menu options and actions available to the user in an ATM system.
 * It allows the user to log in, create an account, and perform various banking operations.
 */
public class OptionMenu {
    private Scanner menuInput;
    private DecimalFormat moneyFormat;
    private HashMap<Integer, Account> accountData;

    /**
     * Constructs an OptionMenu object and initializes necessary components.
     * It creates a Scanner for user input, a DecimalFormat for formatting currency values,
     * and a HashMap to store account data.
     */
    public OptionMenu() {
        menuInput = new Scanner(System.in);
        moneyFormat = new DecimalFormat("'$'###,##0.00");
        accountData = new HashMap<>();
    }

    /**
     * Performs the login operation by prompting the user to enter their customer number and PIN number.
     * If the credentials are valid, it calls the performAccountAction() method for the logged-in account.
     *
     * @throws IOException if an I/O error occurs.
     */
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

                Account account = accountData.get(customerNumber);
                if (account != null && pinNumber == account.getPinNumber()) {
                    performAccountAction(account);
                    loggedIn = true;
                } else {
                    System.out.println("\nWrong Customer Number or Pin Number");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Character(s). Only Numbers.");
                menuInput.next();
            }
        }
    }

    /**
     * Performs the account action based on the selected account type (Checking or Savings).
     * It displays a menu for the user to select various actions such as viewing balance,
     * withdrawing funds, depositing funds, transferring funds, or exiting.
     *
     * @param account the Account object representing the user's account.
     */
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

    /**
     * Performs the checking account action based on the user's selection.
     * It displays a menu for the user to select actions specific to the checking account,
     * such as viewing balance, withdrawing funds, depositing funds, transferring funds to savings, or exiting.
     *
     * @param account the Account object representing the user's account.
     */
    public void performCheckingAccountAction(Account account) {
        boolean end = false;

        while (!end) {
            try {
                System.out.println("\nChecking Account:");
                System.out.println(" Type 1 - View Balance");
                System.out.println(" Type 2 - Withdraw Funds");
                System.out.println(" Type 3 - Deposit Funds");
                System.out.println(" Type 4 - Transfer Funds to Savings");
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
                        account.transferToSaving();
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

    /**
     * Performs the savings account action based on the user's selection.
     * It displays a menu for the user to select actions specific to the savings account,
     * such as viewing balance, withdrawing funds, depositing funds, transferring funds to checking,
     * calculating interest, or exiting.
     *
     * @param account the Account object representing the user's account.
     */
    public void performSavingAccountAction(Account account) {
        boolean end = false;

        while (!end) {
            try {
                System.out.println("\nSavings Account:");
                System.out.println(" Type 1 - View Balance");
                System.out.println(" Type 2 - Withdraw Funds");
                System.out.println(" Type 3 - Deposit Funds");
                System.out.println(" Type 4 - Transfer Funds to Checking");
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
                        account.transferToChecking();
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

    /**
     * Creates a new account by prompting the user to enter a unique customer number and PIN.
     * Adds the new account to the accountData HashMap.
     *
     * @throws IOException if an I/O error occurs.
     */
    public void createAccount() throws IOException {
        int customerNumber = 0;
        boolean end = false;

        while (!end) {
            try {
                System.out.print("\nEnter your customer number: ");
                customerNumber = menuInput.nextInt();

                if (accountData.containsKey(customerNumber)) {
                    System.out.println("\nThis customer number is already registered.");
                    return;
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

    /**
     * Displays the main menu options for the user to log in, create an account, or exit the program.
     *
     * @throws IOException if an I/O error occurs.
     */
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
