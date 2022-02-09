
/*
    Given an sentence (as a string)
    find and return the shortest word
    If it's a tie, return an empty string
*/

class ShortestWordFinder
{
    String find(String sentence)
    {
        // fill in this method
        return "";
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

