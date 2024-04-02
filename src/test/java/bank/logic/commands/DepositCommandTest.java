
package bank.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bank.Ui;
import bank.logic.commands.exceptions.CommandException;
import bank.model.BankAccountModel;
import bank.model.Model;

public class DepositCommandTest {

    private Model mockModel;

    @BeforeEach
    public void setUp() {
        mockModel = mock(BankAccountModel.class);
    }

    @Test
    public void execute_validInput_success() throws CommandException {
        // Arrange
        double depositAmount = 100.0;
        double balance = 500.0;
        DepositCommand depositCommand = new DepositCommand(depositAmount);

        when(mockModel.getBalance()).thenReturn(balance);

        // Act
        CommandResult result = depositCommand.execute(mockModel);

        // Assert
        assertEquals(balance + depositAmount, result.getBalance());
        CommandResult expectedResult = new CommandResult(
                String.format(DepositCommand.MESSAGE_SUCCESS, depositAmount) + Ui.END_OF_COMMAND,
                depositAmount, balance + depositAmount, false, true);

        assertEquals(expectedResult, result);
    }
}
