package com.epita.socra.tools;

import java.util.Arrays;
import java.util.List;

public class MorseConvertor {

    private static List<String> morseList =
            Arrays.asList("_____",
                            ".____",
                            "..___",
                            "...__",
                            "...._",
                            ".....",
                            "_....",
                            "__...",
                            "___..",
                            "____.");

    public static String morseConvertor(String number) {
        StringBuilder nbString = new StringBuilder();
        int lenNb = number.length();

        for (int i = 0; i < lenNb; i++)
        {
            int tmpNb = number.charAt(i) - 48;
            nbString.append(morseList.get(tmpNb));
        }

        return nbString.toString();
    }

}
