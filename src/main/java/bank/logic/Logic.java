package bank.logic;

import bank.logic.commands.CommandResult;
import bank.logic.commands.exceptions.CommandException;
import bank.logic.parser.exceptions.InvalidCommandException;
import bank.logic.parser.exceptions.ParseException;
import bank.model.Model;

/**
 * API of the Logic component.
 */
public interface Logic {

    /**
     * Parses and executes the user input.
     *
     * @param userInput full user input string
     * @param model     The current state of the Bank Account
     * @return the result of the command execution
     * @throws CommandException        if the user input does not conform the
     *                                 expected
     *                                 format
     * @throws ParseException          if the user input does not conform the
     *                                 expected
     *                                 format
     * @throws InvalidCommandException if the user input is not a valid command
     */
    CommandResult parseAndExecute(String userInput, Model model)
            throws CommandException, ParseException, InvalidCommandException;
}
