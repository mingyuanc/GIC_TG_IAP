package bank.model;

import java.util.ArrayList;
import java.util.List;

import bank.logic.commands.CommandResult;

/**
 * Represents the in-memory model of the bank account data.
 * Each instance is immutable.
 */
public class BankAccountModel implements Model {

    private static final int NUM_LEDGER_COLUMNS = 3;

    private final double balance;
    private final List<CommandResult> transactionHistory;

    /**
     * Constructs a {@code BankAccountModel} with the given balance and transaction
     * history.
     *
     * @param balance            The leftover amount in the bank
     * @param transactionHistory The ledger of past command / transactions
     */
    public BankAccountModel(double balance, List<CommandResult> transactionHistory) {
        // Round to 2 decimal places
        // Sometimes the balance can be a double with many decimal places due to
        // imprecision
        this.balance = Math.round(balance * 100.0) / 100.0;
        this.transactionHistory = transactionHistory;
    }

    /**
     * Constructs a new {@code BankAccountModel} with no balance and transaction
     * history.
     */
    public BankAccountModel() {
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public boolean hasTransaction() {
        return !this.transactionHistory.isEmpty();
    }

    @Override
    public CommandResult[] getTransactionHistory() {
        return this.transactionHistory.toArray(new CommandResult[0]);
    }

    @Override
    public BankAccountModel addTransaction(CommandResult transaction) {
        List<CommandResult> newTransactionHistory = new ArrayList<>(this.transactionHistory);
        newTransactionHistory.add(transaction);

        return new BankAccountModel(transaction.getBalance(), newTransactionHistory);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int[] columnWidths = new int[NUM_LEDGER_COLUMNS];

        columnWidths[0] = "Date".length();
        columnWidths[1] = "Amount".length();
        columnWidths[2] = "Balance".length();

        for (CommandResult transaction : this.transactionHistory) {
            columnWidths[0] = Math.max(columnWidths[0], transaction.getDate().length());
            columnWidths[1] = Math.max(columnWidths[1], transaction.getAmountInString().length());
            columnWidths[2] = Math.max(columnWidths[2], transaction.getBalanceInString().length());
        }

        String ledgerFormat = "%-" + columnWidths[0] + "s | %-" + columnWidths[1] + "s | %-" + columnWidths[2] + "s";
        sb.append(String.format(ledgerFormat, "Date", "Amount", "Balance")).append("\n");

        for (CommandResult transaction : this.transactionHistory) {
            sb.append(String.format(ledgerFormat, transaction.getDate(), transaction.getAmountInString(),
                    transaction.getBalanceInString())).append("\n");
        }

        return sb.toString();
    }
}
