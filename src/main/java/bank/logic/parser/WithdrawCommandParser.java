package bank.logic.parser;

import bank.Ui;
import bank.logic.commands.WithdrawCommand;
import bank.logic.parser.exceptions.ParseException;

/**
 * Parses required input arguments and creates a new DepositCommand object
 */
public class WithdrawCommandParser implements CommandParser<WithdrawCommand> {
    private static final String WITHDRAW_PROMPT = "Please enter the amount to withdraw:";

    // Required fields
    private double amount;

    /**
     * Parses the amount to withdraw from the user input
     *
     * @param ui The user interface
     * @return The amount to withdraw
     * @throws ParseException If the user input is invalid, ie not a positive double
     *                        with 2 decimal places
     */
    public double parseAmount(Ui ui) throws ParseException {
        ui.printMessage(WITHDRAW_PROMPT);
        String amountString = ui.readCommand();
        return ParserUtils.toPositiveDoubleWithTwoDp(amountString);
    }

    @Override
    public WithdrawCommand parseRequiredFields(Ui ui) throws ParseException {
        this.amount = parseAmount(ui);
        // Add more fields if necessary

        return new WithdrawCommand(this.amount);
    }
}
