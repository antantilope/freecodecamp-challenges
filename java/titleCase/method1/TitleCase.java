
/*
    Return the provided string with the first letter of each word capitalized.
    Make sure the rest of the word is in lower case.
    For the purpose of this exercise, you should also capitalize connecting words like "the" and "of".

    This method uses a character array.

*/

import java.lang.Character;


class Solver {
    public String titleCase(String input) {
        char[] charInput = input.toCharArray();
        int charInputLength = input.length();
        boolean lastWasSpace = false;
        boolean lastWasUppercase = false;
        for(int i = 0; i < charInputLength; i++) {
            if (charInput[i] == ' ') {
                lastWasSpace = true;
                lastWasUppercase = false;
                continue;
            }
            else if (i == 0) {
                charInput[i] = Character.toUpperCase(charInput[i]);
                lastWasUppercase = true;
            }
            else if(
                !lastWasUppercase
                && lastWasSpace
            ) {
                charInput[i] = Character.toUpperCase(charInput[i]);
                lastWasUppercase = true;
            } else {
                charInput[i] = Character.toLowerCase(charInput[i]);
                lastWasUppercase = false;
                lastWasSpace = false;
            }
        }
        return new String(charInput);
    }
}


class Main {
    public static void main(String[] args) {
        // Grab input data
        String strintToTitleCase = args[0];

        Solver solver = new Solver();
        String result = solver.titleCase(strintToTitleCase);

        System.out.println("Titlecasing: " +  strintToTitleCase);
        System.out.println(result);
    }
}
