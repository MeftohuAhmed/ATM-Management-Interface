import java.io.IOException;

/**
 * The ATM class represents the entry point of the ATM project.
 * It provides the main method to start the application and an introduction method to display project information.
 */
public class ATM {

    /**
     * The main method is the entry point of the ATM project.
     * It creates an instance of the OptionMenu class and calls the displayMainMenu method to start the application.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) throws IOException {
        OptionMenu optionMenu = new OptionMenu();
        introduction();
        optionMenu.displayMainMenu();
    }

    /**
     * Displays an introduction message for the ATM project.
     * Provides a brief description of the project and its functionality.
     */
    public static void introduction() {
        System.out.println("=====================================");
        System.out.println("        WELCOME TO THE ATM PROJECT       ");
        System.out.println("=====================================");
        System.out.println("This project demonstrates an ATM system");
        System.out.println("with various account actions, such as");
        System.out.println("checking balance, withdrawing funds,");
        System.out.println("depositing funds, transferring between");
        System.out.println("checking and savings accounts, and");
        System.out.println("calculating interest on accounts.");
        System.out.println("=====================================");
        System.out.println("           Enjoy the Demo!            ");
        System.out.println("=====================================");
    }
}

