package bank.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bank.logic.commands.CommandResult;

// import bank.logic.commands.CommandResult;

public class BankAccountModelTest {

    private BankAccountModel bankAccountModel;

    @BeforeEach
    public void setUp() {
        bankAccountModel = new BankAccountModel();
    }

    @Test
    public void toString_emptyTransactionHistory_returnsHeaderOnly() {
        // Arrange
        String expected = "Date | Amount | Balance\n";

        // Act
        String actual = bankAccountModel.toString();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void toString_singleTransaction_returnsFormattedTransaction() {
        // Arrange
        CommandResult transaction = new CommandResult("test_response", 1000, 1000, false, false);
        BankAccountModel newBankAccountModel = bankAccountModel.addTransaction(transaction);
        String expected = "Date                  | Amount  | Balance\n"
                + String.format("%s | %s | %s\n", transaction.getDate(), transaction.getAmountInString(),
                        transaction.getBalanceInString());

        // Act
        String actual = newBankAccountModel.toString();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void toString_multipleTransactions_returnsFormattedTransactions() {
        // Arrange
        CommandResult transaction1 = new CommandResult("test_response1", 1000, 1000, false, false);
        CommandResult transaction2 = new CommandResult("test_response2", -10000, 0, false, false);
        CommandResult transaction3 = new CommandResult("test_response3", 12700000, 12700000, false, false);
        BankAccountModel newBankAccountModel = bankAccountModel.addTransaction(transaction1)
                .addTransaction(transaction2).addTransaction(transaction3);
        String expected = "Date                  | Amount      | Balance    \n"
                + String.format("%11s | %-11s | %-11s\n", transaction1.getDate(), transaction1.getAmountInString(),
                        transaction1.getBalanceInString())
                + String.format("%11s | %-11s | %-11s\n", transaction2.getDate(), transaction2.getAmountInString(),
                        transaction2.getBalanceInString())
                + String.format("%11s | %-11s | %-11s\n", transaction3.getDate(), transaction3.getAmountInString(),
                        transaction3.getBalanceInString());

        // Act
        String actual = newBankAccountModel.toString();

        // Assert
        assertEquals(expected, actual);
    }
}
