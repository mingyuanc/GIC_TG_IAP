package bank.logic.parser;

import bank.Ui;
import bank.logic.commands.Command;

/**
 * Parses command that does not require any additional variable
 */
public class NoParameterCommandParser<T extends Command> implements CommandParser<T> {

    private final T command;

    /**
     * Constructor for NoParameterCommandParser
     *
     * @param command Command to be returned
     */
    public NoParameterCommandParser(T command) {
        this.command = command;
    }

    @Override
    public T parseRequiredFields(Ui ui) {
        return this.command;
    }

}
