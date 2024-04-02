package bank.logic;

import bank.Ui;
import bank.logic.commands.CommandResult;
import bank.logic.commands.exceptions.CommandException;
import bank.logic.parser.BankAccountParser;
import bank.logic.parser.exceptions.InvalidCommandException;
import bank.logic.parser.exceptions.ParseException;
import bank.model.Model;

/**
 * Manages the logic of the application.
 */
public class LogicManager implements Logic {

    private final Ui ui;

    private final BankAccountParser parser;

    /**
     * Creates a new LogicManager with the given Ui.
     *
     * @param ui The Ui to be used by the LogicManager.
     */
    public LogicManager(Ui ui) {
        this.ui = ui;
        this.parser = new BankAccountParser();
    }

    @Override
    public CommandResult parseAndExecute(String userInput, Model model)
            throws CommandException, ParseException, InvalidCommandException {
        return parser.parseCommand(userInput).parseRequiredFields(ui).execute(model);
    }
}
