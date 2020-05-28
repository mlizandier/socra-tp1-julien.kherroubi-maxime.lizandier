package com.epita.socra.tools;

import java.util.Scanner;

public class ConsoleAdapter implements IOAdapter {
    private Scanner scan = new Scanner(System.in);

    @Override
    public String read() {
        return scan.nextLine();
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }

}
