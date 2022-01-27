
/*
    Reverse a string.
*/


class Solver
{
    public String reverseString(String input)
    {
        int strLength = input.length();
        if(strLength < 1)
            return "";

        char[] reversedChars = new char[strLength];
        int readIx = strLength - 1;
        int writeIx = 0;
        while(readIx >= 0)
        {
            reversedChars[writeIx] = input.charAt(readIx);
            readIx--;
            writeIx++;
        }
        return new String(reversedChars);
    }
}


class Main {
    public static void main(String[] args) {
        // Grab input data.
        String strintToReverse;
        try {
            strintToReverse = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR, you must provide an input string.");
            System.exit(1);
            return;
        }

        // Process the data.
        Solver solver = new Solver();
        String result = solver.reverseString(strintToReverse);

        // Show the result.
        System.out.println("input " + strintToReverse);
        System.out.println("output " + result);
    }
}
