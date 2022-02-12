
/*
    Given an sentence (as a string)
    find and return the shortest word
    If it's a tie, return an empty string
*/
import java.util.Arrays;
import java.util.Comparator;

class ShortestWordFinder
{
    String find(String sentence)
    {   // Handle edge cases
        if(sentence.length() == 0)
            return "";
        String [] words = sentence.split(" ");
        if(words.length == 1)
            return words[0];

        // Build index -> length pairs
        int[][] metaData = new int[words.length][2];
        for(int i =0; i< words.length; i++) {
            metaData[i][0] = i;
            metaData[i][1] = words[i].length();
        }

        final int INDEX_IX = 0;
        final int LENGTH_IX = 1;
        Arrays.sort(metaData, Comparator.comparingInt(o -> o[LENGTH_IX]));

        // Compare first and second
        if(metaData[0][LENGTH_IX] == metaData[1][LENGTH_IX])
            return ""; // Tied
        else
            return words[metaData[0][INDEX_IX]];
    }
}

class Main
{
    public static boolean checkAnswer(String input, String expected, String actual)
    {
        System.out.println("**************************");
        System.out.println("input " + input);
        System.out.println("actual " + actual);
        System.out.println("expected " + expected);
        boolean failed = !expected.equals(actual);
        if(failed)
            System.out.println("❌ fail");
        else
            System.out.println("✅ pass");
        System.out.println("**************************");
        return failed;
    }

    public static void main(String[] args)
    {
        ShortestWordFinder f = new ShortestWordFinder();
        String actualOut;
        String[][] tests = {
            {"hello world", ""}, // Tie
            {"wizards of waverly place", "of"},
            {"aaa aaaa aa a aaa", "a"},
            {"cat fart dog f", "f"},
            {"reddit facebook AT&T yahoo", "AT&T"},
        };
        boolean anyFailed = false;
        boolean testFailed;
        for(String[] test: tests)
        {
            actualOut = f.find(test[0]);
            testFailed = checkAnswer(test[0], test[1], actualOut);
            anyFailed = anyFailed || testFailed;
        }
        if(anyFailed)
            System.out.println("DONE - TESTS FAILED ❌ some tests did not pass");
        else
            System.out.println("DONE - TESTS PASSED ✅ all tests pass!");
    }
}

