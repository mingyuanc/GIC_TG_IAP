package bank.logic.commands;

import bank.model.Model;

/**
 * Represents a command to print the statement of the bank account.
 */
public class PrintStatementCommand extends Command {

    public static final String COMMAND_WORD = "p";

    @Override
    public CommandResult execute(Model model) {
        String statement = model.toString();
        return new CommandResult(statement, 0, 0, false, false);
    }

}
