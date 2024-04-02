package bank.logic.parser;

import bank.Ui;
import bank.logic.commands.Command;
import bank.logic.parser.exceptions.ParseException;

/**
 * Represents a specific command's parser
 */
public interface CommandParser<T extends Command> {

    /**
     * Parses additional user required field from the Ui
     *
     * @param ui The user interface
     * @return The command with the required fields
     * @throws ParseException If the user input is invalid
     */
    T parseRequiredFields(Ui ui) throws ParseException;

}
