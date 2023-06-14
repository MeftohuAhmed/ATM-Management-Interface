import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**

 The Account class represents a bank account with checking and savings balances.

 It provides methods for performing various banking operations such as withdrawals,

 deposits, transfers, and calculating interest.
 */
class Account {
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance;
    private double savingBalance;
    private DecimalFormat moneyFormat;

    /**

     Constructs an Account object with the specified customer number and PIN.
     The checking and savings balances are initialized to zero.
     @param customerNumber the customer number associated with the account.
     @param pinNumber the PIN associated with the account.
     */
    public Account(int customerNumber, int pinNumber) {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
        checkingBalance = 0;
        savingBalance = 0;
        moneyFormat = new DecimalFormat("'$'###,##0.00");
    }
    /**

     Constructs an Account object with the specified customer number, PIN,
     checking balance, and savings balance.
     @param customerNumber the customer number associated with the account.
     @param pinNumber the PIN associated with the account.
     @param checkingBalance the initial balance of the checking account.
     @param savingBalance the initial balance of the savings account.
     */
    public Account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance) {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
        moneyFormat = new DecimalFormat("'$'###,##0.00");
    }
    /**

     Retrieves the customer number associated with the account.
     @return the customer number.
     */
    public int getCustomerNumber() {
        return customerNumber;
    }
    /**

     Retrieves the PIN associated with the account.
     @return the PIN.
     */
    public int getPinNumber() {
        return pinNumber;
    }
    /**

     Retrieves the balance of the checking account.
     @return the checking account balance.
     */
    public double getCheckingBalance() {
        return checkingBalance;
    }
    /**

     Retrieves the balance of the savings account.
     @return the savings account balance.
     */
    public double getSavingBalance() {
        return savingBalance;
    }
    /**

     Performs a withdrawal from the checking account.

     Prompts the user for the withdrawal amount and updates the balance accordingly.

     Displays an error message if the amount is invalid or exceeds the available balance.
     */
    public void performCheckingWithdrawal() {
        try {
            System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
            System.out.print("Amount you want to withdraw from Checking Account: ");
            double amount = new Scanner(System.in).nextDouble();

            if (amount > 0) {
                if (checkingBalance >= amount) {
                    checkingBalance -= amount;
                    System.out.println("Withdrawal Successful!");
                } else {
                    System.out.println("Insufficient Balance.");
                }
            } else {
                System.out.println("Invalid Amount.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input.");
        }
    }

    /**

     Performs a withdrawal from the savings account.

     Prompts the user for the withdrawal amount and updates the balance accordingly.

     Displays an error message if the amount is invalid or exceeds the available balance.
     */
    public void performSavingWithdrawal() {
        try {
            System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
            System.out.print("Amount you want to withdraw from Savings Account: ");
            double amount = new Scanner(System.in).nextDouble();

            if (amount > 0) {
                if (savingBalance >= amount) {
                    savingBalance -= amount;
                    System.out.println("Withdrawal Successful!");
                } else {
                    System.out.println("Insufficient Balance.");
                }
            } else {
                System.out.println("Invalid Amount.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input.");
        }
    }

    /**

     Performs a deposit into the checking account.

     Prompts the user for the deposit amount and updates the balance accordingly.

     Displays an error message if the amount is invalid.
     */
    public void performCheckingDeposit() {
        try {
            System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
            System.out.print("Amount you want to deposit into Checking Account: ");
            double amount = new Scanner(System.in).nextDouble();

            if (amount > 0) {
                checkingBalance += amount;
                System.out.println("Deposit Successful!");
            } else {
                System.out.println("Invalid Amount.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input.");
        }
    }

    /**

     Performs a deposit into the savings account.

     Prompts the user for the deposit amount and updates the balance accordingly.

     Displays an error message if the amount is invalid.
     */
    public void performSavingDeposit() {
        try {
            System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
            System.out.print("Amount you want to deposit into Savings Account: ");
            double amount = new Scanner(System.in).nextDouble();

            if (amount > 0) {
                savingBalance += amount;
                System.out.println("Deposit Successful!");
            } else {
                System.out.println("Invalid Amount.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input.");
        }
    }

    /**

     Transfers funds from the checking account to the savings account.

     Prompts the user for the transfer amount and updates the balances accordingly.

     Displays an error message if the amount is invalid or exceeds the available balance.
     */
    public void transferToSaving() {
        try {
            System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
            System.out.print("Amount you want to transfer from Checking Account to Savings Account: ");
            double amount = new Scanner(System.in).nextDouble();

            if (amount > 0) {
                if (checkingBalance >= amount) {
                    checkingBalance -= amount;
                    savingBalance += amount;
                    System.out.println("Transfer Successful!");
                } else {
                    System.out.println("Insufficient Balance.");
                }
            } else {
                System.out.println("Invalid Amount.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid Input.");
        }
    }

    /**

     Transfers funds from the savings account to the checking account.

     Prompts the user for the transfer amount and updates the balances accordingly.

     Displays an error message if the amount is invalid or exceeds the available balance.
     */
    public void transferToChecking() {
        try {
            System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
            System.out.print("Amount you want to transfer from Savings Account to Checking Account: ");
            double amount = new Scanner(System.in).nextDouble();

            if (amount > 0) {
                if (savingBalance >= amount) {
                    savingBalance -= amount;
                    checkingBalance += amount;
                    System.out.println("Transfer Successful!");
                } else {
                    System.out.println("Insufficient Balance.");
                }
            } else {
                System.out.println("Invalid Amount.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid Input.");
        }
    }

    /**

     Calculates and adds interest to the specified account based on the interest rate.

     Prompts the user to select the account (checking or savings) and enter the interest rate.

     Displays an error message if the account choice or interest rate is invalid.
     */
    public void calculateInterest() {
        try {
            System.out.println("\nSelect the account to calculate interest:");
            System.out.println("1. Checking");
            System.out.println("2. Savings");
            System.out.print("Choice: ");
            int choice = new Scanner(System.in).nextInt();

            if (choice == 1 || choice == 2) {
                System.out.print("Enter the interest rate (in percentage): ");
                double interestRate = new Scanner(System.in).nextDouble();

                if (interestRate >= 0) {
                    double interest;
                    if (choice == 1) {
                        interest = checkingBalance * (interestRate / 100);
                        checkingBalance += interest;
                        System.out.println("Interest calculated and added to Checking Account.");
                    } else {
                        interest = savingBalance * (interestRate / 100);
                        savingBalance += interest;
                        System.out.println("Interest calculated and added to Savings Account.");
                    }
                    System.out.println("Interest Amount: " + moneyFormat.format(interest));
                } else {
                    System.out.println("Invalid Interest Rate.");
                }
            } else {
                System.out.println("Invalid Choice.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input.");
        }
    }
}



