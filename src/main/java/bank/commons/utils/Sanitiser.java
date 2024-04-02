package bank.commons.utils;

/**
 * A class containing utility methods for sanitising user input.
 */
public class Sanitiser {

    /**
     * Sanitises a string by removing leading and trailing whitespace
     * and changing it to lower case.
     *
     * @param input User input
     * @return Sanitised string
     */
    public static String sanitiseInput(String input) {
        return input.trim().toLowerCase();
    }
}
