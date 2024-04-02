package bank.logic.parser;

import bank.logic.parser.exceptions.ParseException;

/**
 * Contains utility methods for parsing
 */
public class ParserUtils {

    private static final String INVALID_POSITIVE_INPUT = "%s is not an positive amount,"
            + " Please enter a valid positive amount to deposit.";

    private static final String INVALID_INPUT = "%s is not an numeric amount,"
            + " Please enter a valid positive numeric amount to deposit.";

    private static final String INVALID_DP_INPUT = "%s has too many decimal places,"
            + " Please enter a valid positive amount with 2 decimal places to deposit.";

    /**
     * Attempts to convert string input to a positive double with 2 decimal places.
     *
     * @param input the input to be converted
     * @return the positive double with 2 decimal places
     * @throws ParseException if input is not a positive double with 2 decimal
     *                        places
     */
    public static double toPositiveDoubleWithTwoDp(String input) throws ParseException {
        try {

            // Checks that string does not end with d / f
            // Java Double::parseDouble will successfully parse these invalid strings
            if (input.endsWith("d") || input.endsWith("f")) {
                throw new ParseException(String.format(INVALID_INPUT, input));
            }

            double value;
            try {
                value = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                throw new ParseException(String.format(INVALID_INPUT, input));
            }

            // Checks if value is positive
            if (value <= 0) {
                throw new ParseException(String.format(INVALID_POSITIVE_INPUT, input));
            }

            // Checks that it has 2 decimal places
            if (value % 1 == 0) {
                // Handle pure integers
                return value;
            }
            int decimalPlaces = String.valueOf(value).split("\\.")[1].length();
            if (decimalPlaces > 2) {
                throw new ParseException(String.format(INVALID_DP_INPUT, input));
            }

            return value;

        } catch (NumberFormatException e) {
            throw new ParseException(String.format(INVALID_INPUT, input));
        }
    }
}
