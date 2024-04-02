package bank.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import bank.logic.parser.exceptions.ParseException;

public class ParserUtilTest {

    @Test
    public void toPositiveDoubleWithTwoDp_validPositiveInput() {
        String input = "10.50";
        double expected = 10.5;
        try {
            double actual = ParserUtils.toPositiveDoubleWithTwoDp(input);
            assertEquals(expected, actual);
        } catch (ParseException e) {
            fail();
        }

    }

    @Test
    public void toPositiveDoubleWithTwoDp_zeroInput() {
        String input = "0";
        assertThrows(ParseException.class, () -> ParserUtils.toPositiveDoubleWithTwoDp(input));
    }

    @Test
    public void toPositiveDoubleWithTwoDp_negativeInput() {
        String input = "-10.5";
        assertThrows(ParseException.class, () -> ParserUtils.toPositiveDoubleWithTwoDp(input));
    }

    @Test
    public void toPositiveDoubleWithTwoDp_trailingZeros_noErrors() {
        String input = "19.600";
        double expected = 19.60;
        try {
            double actual = ParserUtils.toPositiveDoubleWithTwoDp(input);
            assertEquals(expected, actual);
        } catch (ParseException e) {
            fail();
        }
    }

    @Test
    public void toPositiveDoubleWithTwoDp_specialNumbers_noErrors() {
        String input = "19.90";
        double expected = 19.90;
        try {
            double actual = ParserUtils.toPositiveDoubleWithTwoDp(input);
            assertEquals(expected, actual);
        } catch (ParseException e) {
            fail();
        }
    }

    @Test
    public void toPositiveDoubleWithTwoDp_specialNumbers_errorThrown() {
        String input = "19.901";
        assertThrows(ParseException.class, () -> ParserUtils.toPositiveDoubleWithTwoDp(input));
    }

    @Test
    public void toPositiveDoubleWithTwoDp_moreThan2DpInput() {
        String input = "10.555";
        assertThrows(ParseException.class, () -> ParserUtils.toPositiveDoubleWithTwoDp(input));
    }

    @Test
    public void toPositiveDoubleWithTwoDp_longInput() {
        String input = "1000000000000000000000";
        double expected = 1000000000000000000000.0;
        try {
            double actual = ParserUtils.toPositiveDoubleWithTwoDp(input);
            assertEquals(expected, actual);
        } catch (ParseException e) {
            fail();
        }
    }

    @Test
    public void toPositiveDoubleWithTwoDp_invalidInput() {
        String input = "abc";
        assertThrows(ParseException.class, () -> ParserUtils.toPositiveDoubleWithTwoDp(input));
    }

    @Test
    public void toPositiveDoubleWithTwoDp_endWithInvalidChar() {
        String input = "100d";
        assertThrows(ParseException.class, () -> ParserUtils.toPositiveDoubleWithTwoDp(input));
    }
}
