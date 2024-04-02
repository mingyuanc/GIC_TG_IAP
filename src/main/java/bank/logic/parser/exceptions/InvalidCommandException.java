package bank.logic.parser.exceptions;

/**
 * Represents an unrecognisable command entered by the user.
 */
public class InvalidCommandException extends Exception {

    public InvalidCommandException(String message) {
        super(message);
    }

}
