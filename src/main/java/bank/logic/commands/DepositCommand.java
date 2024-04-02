package bank.logic.commands;

import bank.Ui;
import bank.model.Model;

/**
 * Represents a command to deposit money into the bank account.
 */
public class DepositCommand extends Command {

    public static final String COMMAND_WORD = "d";

    public static final String MESSAGE_SUCCESS = "Thank you. $%.2f has been deposited to your account.";

    private final double amount;

    public DepositCommand(double amount) {
        this.amount = amount;
    }

    @Override
    public CommandResult execute(Model model) {
        double balance = model.getBalance() + this.amount;

        String depositMessage = String.format(MESSAGE_SUCCESS, this.amount) + Ui.END_OF_COMMAND;

        return new CommandResult(depositMessage, this.amount, balance, false, true);
    }

}
