package bank.logic.parser;

import bank.Ui;
import bank.logic.commands.DepositCommand;
import bank.logic.parser.exceptions.ParseException;

/**
 * Parses required input arguments and creates a new DepositCommand object
 */
public class DepositCommandParser implements CommandParser<DepositCommand> {

    public static final String DEPOSIT_PROMPT = "Please enter the amount to deposit:";

    // Required fields
    private double amount;

    /**
     * Parses the amount to deposit from the user input
     *
     * @param ui The user interface
     * @return The amount to deposit
     * @throws ParseException If the user input is invalid, ie not a positive double
     *                        with 2 decimal places
     */
    public double parseAmount(Ui ui) throws ParseException {
        ui.printMessage(DEPOSIT_PROMPT);
        String amountString = ui.readCommand();
        return ParserUtils.toPositiveDoubleWithTwoDp(amountString);
    }

    @Override
    public DepositCommand parseRequiredFields(Ui ui) throws ParseException {
        this.amount = parseAmount(ui);
        // Add more fields if necessary

        return new DepositCommand(this.amount);
    }

}
