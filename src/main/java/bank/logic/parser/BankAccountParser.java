package bank.logic.parser;

import java.util.HashMap;
import java.util.Map;

import bank.commons.utils.Sanitiser;
import bank.logic.commands.Command;
import bank.logic.commands.DepositCommand;
import bank.logic.commands.PrintStatementCommand;
import bank.logic.commands.QuitCommand;
import bank.logic.commands.WithdrawCommand;
import bank.logic.parser.exceptions.InvalidCommandException;

/**
 * Parses bank account related user commands.
 */
public class BankAccountParser implements Parser {

    private final Map<String, CommandParser<? extends Command>> commandToHandler = new HashMap<>();

    /**
     * Creates a new BankAccountParser with the default commands.
     */
    public BankAccountParser() {
        commandToHandler.put(WithdrawCommand.COMMAND_WORD, new WithdrawCommandParser());
        commandToHandler.put(DepositCommand.COMMAND_WORD, new DepositCommandParser());
        commandToHandler.put(PrintStatementCommand.COMMAND_WORD,
                new NoParameterCommandParser<>(new PrintStatementCommand()));
        commandToHandler.put(QuitCommand.COMMAND_WORD, new NoParameterCommandParser<>(new QuitCommand()));
    }

    @Override
    public CommandParser<? extends Command> parseCommand(String userInput) throws InvalidCommandException {
        String commandWord = Sanitiser.sanitiseInput(userInput);

        if (commandToHandler.containsKey(commandWord)) {
            return commandToHandler.get(commandWord);
        }

        throw new InvalidCommandException("Invalid command! Please enter a valid command.");
    }

}
