package bank;

import java.util.Scanner;

/**
 * Handles the interaction with user
 */
public class Ui {

    /**
     * End of command message
     */
    public static final String END_OF_COMMAND = "\nIs there anything else you'd like to do?"
            + "\n[D]eposit\n[W]ithdraw\n[P]rint statement\n[Q]uit\n";

    /**
     * Default Welcome Message
     */
    private static final String WELCOME_MESSAGE = "Welcome to AwesomeGIC Bank!"
            + " What would you like to do?\n[D]eposit\n[W]ithdraw\n[P]rint statement\n[Q]uit";

    /**
     * Default Goodbye Message
     */
    private static final String GOODBYE_MESSAGE = "Thank you for banking with AwesomeGIC Bank.\nHave a nice day!";

    private final Scanner scanner;

    /**
     * Constructs an Ui class that reads from System.in
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Constructs an Ui class that reads from a custom scanner
     *
     * @param scanner Scanner to be used
     */
    public Ui(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Prints the default welcome message
     */
    public void welcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    /**
     * Prints the default welcome message
     */
    public void exitMessage() {
        System.out.println(GOODBYE_MESSAGE);
        this.scanner.close();
    }

    /**
     * Prints the message.
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Standardises the printing of error messages.
     */
    public void printErrorMessage(String message) {
        System.out.println("Transaction failed:\n" + message + END_OF_COMMAND);
    }

    /**
     * Reads a line of command to be parsed.
     *
     * @return the line of command read
     */
    public String readCommand() {
        String ret = scanner.nextLine();
        while (ret.isEmpty()) {
            ret = scanner.nextLine();
        }
        return ret;
    }
}
