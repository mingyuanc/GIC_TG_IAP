package bank;

import bank.logic.Logic;
import bank.logic.LogicManager;
import bank.logic.commands.CommandResult;
import bank.logic.commands.exceptions.CommandException;
import bank.logic.parser.exceptions.InvalidCommandException;
import bank.logic.parser.exceptions.ParseException;
import bank.model.BankAccountModel;
import bank.model.Model;

/**
 * Represents a bank account.
 */
public class BankAccount {

    /**
     * Instance handling all the user interface.
     */
    private final Ui ui;

    /**
     * Instance handling all the logic of the bank account.
     */
    private final Logic logic;

    /**
     * Instance representing the bank account model.
     */
    private Model model;

    /**
     * Constructors a new bank account.
     */
    public BankAccount() {
        this.ui = new Ui();
        this.model = new BankAccountModel();
        this.logic = new LogicManager(ui);
    }

    public static void main(String[] args) {
        new BankAccount().run();
    }

    /**
     * Starts the bank account application.
     */
    private void run() {
        ui.welcomeMessage();
        this.listen();
        ui.exitMessage();
    }

    /**
     * Listens to the user input and executes the commands.
     */
    private void listen() {
        while (true) {
            try {
                String userInput = ui.readCommand();

                CommandResult result = this.logic.parseAndExecute(userInput, model);

                if (result.isExit()) {
                    break;
                }

                if (result.affectsLedger()) {
                    this.model = this.model.addTransaction(result);
                }
                this.ui.printMessage(result.getResponse());
            } catch (InvalidCommandException e) {
                ui.printMessage(e.getMessage());
            } catch (ParseException | CommandException e) {
                ui.printErrorMessage(e.getMessage());
            }
        }
    }
}
