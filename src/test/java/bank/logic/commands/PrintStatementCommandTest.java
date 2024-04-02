package bank.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bank.logic.commands.exceptions.CommandException;
import bank.model.Model;

public class PrintStatementCommandTest {

    private Model mockModel;

    @BeforeEach
    public void setUp() {
        mockModel = mock(Model.class);
    }

    @Test
    public void execute_validModel_printsStatement() throws CommandException {
        // Arrange
        String expectedStatement = this.mockModel.toString();
        PrintStatementCommand printStatementCommand = new PrintStatementCommand();

        // Act
        CommandResult result = printStatementCommand.execute(mockModel);

        // Assert
        CommandResult expectedResult = new CommandResult(expectedStatement, 0, 0, false, false);
        assertEquals(expectedResult, result);

    }
}
