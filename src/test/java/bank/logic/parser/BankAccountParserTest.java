package bank.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bank.logic.commands.Command;
import bank.logic.parser.exceptions.InvalidCommandException;

public class BankAccountParserTest {

    private BankAccountParser parser;

    @BeforeEach
    public void setUp() {
        parser = new BankAccountParser();
    }

    @Test
    public void parseCommand_validCommand_returnsCorrectCommand() {
        String userInput = "w";
        try {
            CommandParser<? extends Command> commandParser = parser.parseCommand(userInput);
            assertEquals(WithdrawCommandParser.class, commandParser.getClass());

            userInput = "d";
            commandParser = parser.parseCommand(userInput);
            assertEquals(DepositCommandParser.class, commandParser.getClass());

            userInput = "p";
            commandParser = parser.parseCommand(userInput);
            assertEquals(NoParameterCommandParser.class, commandParser.getClass());

            userInput = "q";
            commandParser = parser.parseCommand(userInput);
            assertEquals(NoParameterCommandParser.class, commandParser.getClass());

            userInput = "W";
            commandParser = parser.parseCommand(userInput);
            assertEquals(WithdrawCommandParser.class, commandParser.getClass());

            userInput = "D";
            commandParser = parser.parseCommand(userInput);
            assertEquals(DepositCommandParser.class, commandParser.getClass());

            userInput = "P";
            commandParser = parser.parseCommand(userInput);
            assertEquals(NoParameterCommandParser.class, commandParser.getClass());

            userInput = "Q";
            commandParser = parser.parseCommand(userInput);
            assertEquals(NoParameterCommandParser.class, commandParser.getClass());
        } catch (InvalidCommandException e) {
            fail();
        }
    }

    @Test
    public void testSanitise_validCommandLeadingAndTrailingSpace_returnsCorrectCommand() {
        try {
            String userInput = "w ";
            CommandParser<? extends Command> commandParser = parser.parseCommand(userInput);
            assertEquals(WithdrawCommandParser.class, commandParser.getClass());

            userInput = " d";
            commandParser = parser.parseCommand(userInput);
            assertEquals(DepositCommandParser.class, commandParser.getClass());

            userInput = "p  ";
            commandParser = parser.parseCommand(userInput);
            assertEquals(NoParameterCommandParser.class, commandParser.getClass());
        } catch (InvalidCommandException e) {
            fail();
        }

    }

    @Test
    public void parseCommand_invalidCommand_throwsParseException() {
        String userInput = "dd";
        assertThrows(InvalidCommandException.class, () -> parser.parseCommand(userInput));
    }
}
