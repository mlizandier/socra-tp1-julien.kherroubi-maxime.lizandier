package com.epita.socra.app.tools;

public class NumberValidator {
    public static boolean isValidNumber(String number) {
        try {
            int nb = Integer.parseInt(number);
            if (nb < 0) {
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
