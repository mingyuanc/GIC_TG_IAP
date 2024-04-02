package bank.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bank.Ui;
import bank.logic.commands.exceptions.CommandException;
import bank.model.BankAccountModel;
import bank.model.Model;

public class WithdrawCommandTest {

    private Model mockModel;

    @BeforeEach
    public void setUp() {
        mockModel = mock(BankAccountModel.class);
    }

    @Test
    public void execute_validWithdrawAmount_success() throws CommandException {
        // Arrange
        double balance = 100.0;
        double withdrawAmount = 50.0;
        WithdrawCommand withdrawCommand = new WithdrawCommand(withdrawAmount);
        when(mockModel.getBalance()).thenReturn(balance);

        // Act
        CommandResult result = withdrawCommand.execute(mockModel);

        // Assert
        double expectedBalance = balance - withdrawAmount;
        String expectedMessage = String.format("Thank you. $%.2f has been withdrawn.", withdrawAmount)
                + Ui.END_OF_COMMAND;
        CommandResult expectedResult = new CommandResult(expectedMessage, withdrawAmount * -1, expectedBalance, false,
                true);

        assertEquals(expectedResult, result);
    }

    @Test
    public void execute_insufficientFunds_throwsCommandException() {
        // Arrange
        double balance = 100.0;
        double withdrawAmount = 150.00;
        WithdrawCommand withdrawCommand = new WithdrawCommand(withdrawAmount);
        when(mockModel.getBalance()).thenReturn(balance);

        // Act & Assert
        assertThrows(CommandException.class, () -> withdrawCommand.execute(mockModel));
    }
}
