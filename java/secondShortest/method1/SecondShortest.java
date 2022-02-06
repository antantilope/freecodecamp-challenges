
/*

    > Given a string
      > find the second shortest word in the string. Return the second shortest string
      > If there's a tie for second shortest, return the constant TIED

*/

class Solver {

    static final String TIED = "<__TIED__>";

    public String secondShortest(String sentenceToSearch) {
        /* Add code below */

        return "";
        /* Add code above */
    }

    public boolean getAndShowResult(String input, String actual, String expected) {
        boolean failed = actual != expected;
        String msg = "";
        msg += "******************";
        msg += "\n input " + input;
        msg += "\n output " + actual;
        msg += "\n expected " + expected;
        msg += "\n";
        msg += failed ? "❌ unexpected response" : "✅ pass!";
        msg += "\n*******************";
        System.out.println(msg);
        return failed;
    }

}


class Main {

    public static void main(String[] args) {
        // Create inputs and expected outputs
        String[][] inputsAndExpectedOuts = {
            {"hello world", Solver.TIED },
            {"My name is earl", "name" },
            {"The quick brown fox jumped over the lazy dogs", Solver.TIED },
            {"Lorem ipsum dolor sit amet foo", "amet"},
            {"asdf", "3456754", "a", "hyy", "b", "htyr", "hyy"},
        };

        boolean anyFailed = false;
        Solver x = new Solver();
        for(String[] testValues: inputsAndExpectedOuts) {
            String testInput = testValues[0];
            String expectedOut = testValues[1];
            String actualOut = x.secondShortest(testInput);
            boolean isFailed = x.getAndShowResult(testInput, actualOut, expectedOut);
            if(!anyFailed && isFailed)
                anyFailed = true;
        }
        if(anyFailed)
            System.out.println("DONE - TESTS FAILED ❌ some tests did not pass");
        else
            System.out.println("DONE - TESTS PASSED ✅ all tests pass!");
    }
}