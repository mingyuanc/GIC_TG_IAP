package bank.model;

import bank.logic.commands.CommandResult;

/**
 * API of the Model component.
 */
public interface Model {

    /**
     * Returns the balance of the bank account
     */
    double getBalance();

    /**
     * Returns true a transaction has been done
     */
    boolean hasTransaction();

    /**
     * Returns the transaction history of the bank account
     */
    CommandResult[] getTransactionHistory();

    /**
     * Adds a transaction to the bank account
     *
     * @param transaction the transaction to be added
     * @return the new bank account model with the transaction added
     */
    Model addTransaction(CommandResult transaction);

}
