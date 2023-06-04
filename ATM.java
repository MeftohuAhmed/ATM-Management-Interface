import java.io.IOException;

public class ATM {

    public static void main(String[] args) throws IOException {
        OptionMenu optionMenu = new OptionMenu();
        introduction();
        optionMenu.displayMainMenu();
    }

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
