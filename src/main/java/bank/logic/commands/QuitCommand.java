package bank.logic.commands;

import bank.model.Model;

/**
 * Represents a command to quit the application.
 */
public class QuitCommand extends Command {

    public static final String COMMAND_WORD = "q";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult("", 0, 0, true, false);
    }

}
