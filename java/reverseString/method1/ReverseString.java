
/*
    Reverse a string.
*/


class Solver
{
    public String reverseString(String input)
    {
        int ix = input.length() - 1;
        if(ix < 0)
            return "";
        String reversedString = "";
        for ( ; ix >= 0; ix--)
            reversedString += input.charAt(ix);
        return reversedString;
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
