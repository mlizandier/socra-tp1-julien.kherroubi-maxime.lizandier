package com.epita.socra;

import com.epita.socra.tools.IOAdapter;
import com.epita.socra.tools.MorseConvertor;
import com.epita.socra.tools.NumberValidator;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class AppTest {

    @Test
    public void testValidConsole()
    {
        IOAdapter fakeIoAdapter = mock(IOAdapter.class);
        when(fakeIoAdapter.read()).thenReturn("1903");
        App app = new App(fakeIoAdapter);
        app.run();

        verify(fakeIoAdapter).write("Enter a positive or null number.");
        verify(fakeIoAdapter).write(argThat(message -> message.contains(".________._____...__")));
    }

    @Test
    public void testInvalidInputConsole()
    {
        IOAdapter fakeIoAdapter = mock(IOAdapter.class);
        when(fakeIoAdapter.read()).thenReturn("abc");
        App app = new App(fakeIoAdapter);
        app.run();

        verify(fakeIoAdapter).write("Enter a positive or null number.");
        verify(fakeIoAdapter).write(argThat(message -> message.contains("goodbye")));
    }

    @Test
    public void testInvalidNumberConsole()
    {
        IOAdapter fakeIoAdapter = mock(IOAdapter.class);
        when(fakeIoAdapter.read()).thenReturn("-777");
        App app = new App(fakeIoAdapter);
        app.run();

        verify(fakeIoAdapter).write("Enter a positive or null number.");
        verify(fakeIoAdapter).write(argThat(message -> message.contains("goodbye")));
    }

    @Test
    public void invalidNumberTest() {
        assertFalse(NumberValidator.isValidNumber("-10"));
    }

    @Test
    public void invalidInputTest() {
        assertFalse(NumberValidator.isValidNumber("abc"));
    }

    @Test
    public void validZeroTest() {
        assertTrue(NumberValidator.isValidNumber("0"));
    }

    @Test
    public void validNumberTest() {
        assertTrue(NumberValidator.isValidNumber("100"));
    }

    @Test
    public void zeroMorse() {
        assertTrue("_____".equals(MorseConvertor.morseConvertor("0")));
    }

    @Test
    public void oneMorse() {
        assertTrue(".____".equals(MorseConvertor.morseConvertor("1")));
    }

    @Test
    public void twoMorse() {
        assertTrue("..___".equals(MorseConvertor.morseConvertor("2")));
    }

    @Test
    public void threeMorse() {
        assertTrue("...__".equals(MorseConvertor.morseConvertor("3")));
    }

    @Test
    public void fourMorse() {
        assertTrue("...._".equals(MorseConvertor.morseConvertor("4")));
    }

    @Test
    public void fiveMorse() {
        assertTrue(".....".equals(MorseConvertor.morseConvertor("5")));
    }

    @Test
    public void sixMorse() {
        assertTrue("_....".equals(MorseConvertor.morseConvertor("6")));
    }

    @Test
    public void sevenMorse() {
        assertTrue("__...".equals(MorseConvertor.morseConvertor("7")));
    }

    @Test
    public void eightMorse() {
        assertTrue("___..".equals(MorseConvertor.morseConvertor("8")));
    }

    @Test
    public void nineMorse() {
        assertTrue("____.".equals(MorseConvertor.morseConvertor("9")));
    }

    @Test
    public void fourtyTwoMorse() {
        assertTrue("...._..___".equals(MorseConvertor.morseConvertor("42")));
    }

    @Test
    public void sixSixSixMorse() {
        assertTrue("_...._...._....".equals(MorseConvertor.morseConvertor("666")));
    }

    @Test
    public void oneNineZeroThreeMorse() {
        assertTrue(".________._____...__".equals(MorseConvertor.morseConvertor("1903")));
    }

    @Test
    public void oneTwoThreeFourFiveMorse() {
        assertTrue(".____..___...__...._.....".equals(MorseConvertor.morseConvertor("12345")));
    }

    @Test
    public void oneTwoThreeFourFiveSixMorse() {
        assertTrue(".____..___...__...._....._....".equals(MorseConvertor.morseConvertor("123456")));
    }

    @Test
    public void oneTwoThreeFourFiveSixSevenMorse() {
        assertTrue(".____..___...__...._....._....__...".equals(MorseConvertor.morseConvertor("1234567")));
    }

    @Test
    public void oneTwoThreeFourFiveSixSevenEightMorse() {
        assertTrue(".____..___...__...._....._....__...___..".equals(MorseConvertor.morseConvertor("12345678")));
    }

    @Test
    public void oneTwoThreeFourFiveSixSevenEightNineMorse() {
        assertTrue(".____..___...__...._....._....__...___..____.".equals(MorseConvertor.morseConvertor("123456789")));
    }
}
