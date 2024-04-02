package bank.logic.commands;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Represents the result when executing a command
 */
public class CommandResult {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("d MMM yyyy h:mm:ssa",
            Locale.ENGLISH);

    private final String userResponse;

    /** If application should exit. */
    private final boolean exit;

    /** If command affects ledger */
    private final boolean affectsLedger;

    private final double amount;

    private final double balance;

    private final LocalDateTime date;

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     *
     * @param userResponse  Response to be displayed to the user
     * @param amount        Amount of the transaction
     * @param balance       Balance after the transaction
     * @param exit          If application should exit
     * @param affectsLedger If command affects ledger
     */
    public CommandResult(String userResponse, double amount, double balance, boolean exit, boolean affectsLedger) {
        this.userResponse = userResponse;
        this.exit = exit;
        this.amount = amount;
        this.balance = balance;
        this.affectsLedger = affectsLedger;
        this.date = LocalDateTime.now();
    }

    /**
     * Gets the response displayed to the user
     *
     * @return The feedback message as a String.
     */
    public String getResponse() {
        return this.userResponse;
    }

    /**
     * Gets the balance after the transaction
     *
     * @return The balance after the transaction as a double.
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Gets the amount of the transaction in a string
     *
     * @return The amount of the transaction as a string.
     */
    public String getAmountInString() {
        return String.format("%.2f", this.amount);
    }

    /**
     * Gets the balance after the transaction in a string
     *
     * @return The balance after the transaction as a string.
     */
    public String getBalanceInString() {
        return String.format("%.2f", this.balance);
    }

    /**
     * Gets the date of the transaction
     *
     * @return The date of the transaction as a formatted string.
     */
    public String getDate() {
        return date.format(DATE_TIME_FORMATTER);
    }

    /**
     * Checks if the application should exit.
     *
     * @return {@code true} if the application should exit, {@code false} otherwise.
     */
    public boolean isExit() {
        return exit;
    }

    /**
     * Checks if the command affects the ledger.
     *
     * @return {@code true} if the command affects the ledger, {@code false}
     *         otherwise.
     */
    public boolean affectsLedger() {
        return this.affectsLedger;
    }

    @Override
    public String toString() {
        return String.format("%20s | %-10.2f | %-10.2f", date.format(DATE_TIME_FORMATTER), amount, balance);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof CommandResult)) {
            return false;
        }

        CommandResult other = (CommandResult) obj;
        return userResponse.equals(other.userResponse) && exit == other.exit && amount == other.amount
                && balance == other.balance && this.getDate().equals(other.getDate());
    }
}
