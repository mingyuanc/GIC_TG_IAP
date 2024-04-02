package bank.logic.parser;

import bank.logic.commands.Command;
import bank.logic.parser.exceptions.InvalidCommandException;

/**
 * Represents a parser to parse user input into commands for execution.
 */
public interface Parser {

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws InvalidCommandException if the user input does not conform the
     *                                 expected format
     */
    CommandParser<? extends Command> parseCommand(String userInput) throws InvalidCommandException;

}
