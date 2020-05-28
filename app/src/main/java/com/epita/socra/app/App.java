package com.epita.socra.app;

import com.epita.socra.app.tools.ConsoleAdapter;
import com.epita.socra.app.tools.IOAdapter;
import com.epita.socra.app.tools.MorseConvertor;
import com.epita.socra.app.tools.NumberValidator;

public class App {
    private IOAdapter adapter;

    private App() {
        this(new ConsoleAdapter());
    }

    public App(IOAdapter adapter) {
        this.adapter = adapter;
    }

    public static void main(String[] args) {
        App application = new App();
        application.run();
    }

    public void run() {
        adapter.write("Enter a positive or null number.");
        String number = adapter.read();

        // Check if is a number
        if (!NumberValidator.isValidNumber(number))
        {
            adapter.write("It is not a positive or null number, goodbye.");
        }
        else {

            adapter.write(MorseConvertor.morseConvertor(number));
        }
    }
}
