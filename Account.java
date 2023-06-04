import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance;
    private double savingBalance;
    private Scanner input;
    private DecimalFormat moneyFormat;

    public Account(int customerNumber, int pinNumber) {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
        checkingBalance = 0;
        savingBalance = 0;
        input = new Scanner(System.in);
        moneyFormat = new DecimalFormat("'$'###,##0.00");
    }

    public Account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance) {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
        input = new Scanner(System.in);
        moneyFormat = new DecimalFormat("'$'###,##0.00");
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void performCheckingWithdrawal() {
        try {
            System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
            System.out.print("Amount you want to withdraw from Checking Account: ");
            double amount = input.nextDouble();

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
            input.next();
        }
    }

    public void performSavingWithdrawal() {
        try {
            System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
            System.out.print("Amount you want to withdraw from Savings Account: ");
            double amount = input.nextDouble();

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
            input.next();
        }
    }

    public void performCheckingDeposit() {
        try {
            System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
            System.out.print("Amount you want to deposit into Checking Account: ");
            double amount = input.nextDouble();

            if (amount > 0) {
                checkingBalance += amount;
                System.out.println("Deposit Successful!");
            } else {
                System.out.println("Invalid Amount.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input.");
            input.next();
        }
    }

    public void performSavingDeposit() {
        try {
            System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
            System.out.print("Amount you want to deposit into Savings Account: ");
            double amount = input.nextDouble();

            if (amount > 0) {
                savingBalance += amount;
                System.out.println("Deposit Successful!");
            } else {
                System.out.println("Invalid Amount.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input.");
            input.next();
        }
    }

    public void performTransfer(String accountType) {
        try {
            System.out.println("\nSelect an account you wish to transfer funds to:");
            System.out.println("1. Checking");
            System.out.println("2. Savings");
            System.out.print("Choice: ");
            int choice = input.nextInt();

            if (choice == 1 || choice == 2) {
                System.out.print("Amount you want to transfer: ");
                double amount = input.nextDouble();

                if (amount > 0) {
                    if (accountType.equals("Checking")) {
                        if (choice == 1) {
                            if (checkingBalance >= amount) {
                                checkingBalance -= amount;
                                savingBalance += amount;
                                System.out.println("Transfer Successful!");
                            } else {
                                System.out.println("Insufficient Balance.");
                            }
                        } else {
                            System.out.println("Invalid Choice.");
                        }
                    } else if (accountType.equals("Savings")) {
                        if (choice == 2) {
                            if (savingBalance >= amount) {
                                savingBalance -= amount;
                                checkingBalance += amount;
                                System.out.println("Transfer Successful!");
                            } else {
                                System.out.println("Insufficient Balance.");
                            }
                        } else {
                            System.out.println("Invalid Choice.");
                        }
                    }
                } else {
                    System.out.println("Invalid Amount.");
                }
            } else {
                System.out.println("Invalid Choice.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input.");
            input.next();
        }
    }

    public void calculateInterest() {
        try {
            System.out.println("\nSelect the account to calculate interest:");
            System.out.println("1. Checking");
            System.out.println("2. Savings");
            System.out.print("Choice: ");
            int choice = input.nextInt();

            if (choice == 1 || choice == 2) {
                System.out.print("Enter the interest rate (in percentage): ");
                double interestRate = input.nextDouble();

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
            input.next();
        }
    }
}