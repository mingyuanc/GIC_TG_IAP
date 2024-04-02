package bank.logic.commands;

import bank.Ui;
import bank.logic.commands.exceptions.CommandException;
import bank.model.Model;

/**
 * Represents a command to withdraw money from the bank account.
 *
 */
public class WithdrawCommand extends Command {

    public static final String COMMAND_WORD = "w";

    private static final String MESSAGE_SUCCESS = "Thank you. $%.2f has been withdrawn.";

    private static final String MESSAGE_FAILURE = "Insufficient funds to withdraw $%.2f,"
            + " your current balance is $%.2f.";

    private final double amount;

    public WithdrawCommand(double amount) {
        this.amount = amount;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        if (this.amount > model.getBalance()) {
            throw new CommandException(String.format(MESSAGE_FAILURE, this.amount, model.getBalance()));
        }

        double balance = model.getBalance() - this.amount;

        String withdrawMessage = String.format(MESSAGE_SUCCESS, this.amount) + Ui.END_OF_COMMAND;

        return new CommandResult(withdrawMessage, this.amount * -1, balance, false, true);
    }

}
