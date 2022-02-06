
/*

    Given a string and a maximum string length, truncate the string
        if the string length is over the max, trim the string and add "..." to the end of it
        if the string lenght is NOT over the max, return the original string.
        if the string is empty, return an empty string

        example
            string: "helloworld!"
            max length: 2
            return "he..."

            string: "hello"
            max length: 5
            retrun "hello"
*/

class Solver {
    public String truncateString(String stringToTruncate, int maxLength) {
        /* Add code below */

        /* Add code above */

        return ""; // Remove this line of code.
    }

    public boolean getAndShowResult(String input, String actual, String expected) {
        boolean failed = !actual.equals(expected);
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
        String[][] inputsAndExpectedOutputs = {
            {"foooooobaaaaaaar", "15", "foooooobaaaaaaa..." },
            {"hello world", "11", "hello world" },
            {"hello world", "10", "hello worl..." },
            {"", "10", "" },
            {
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed",
                "12",
                "Lorem ipsum ...",
            },
        };

        boolean anyFailed = false;
        Solver x = new Solver();
        for(String[] testValues: inputsAndExpectedOutputs) {
            String testInputString = testValues[0];
            int testInputMaxLength = Integer.parseInt(testValues[1]);
            String actualOut = x.truncateString(testInputString, testInputMaxLength);
            String expectedOut = testValues[2];
            boolean isFailed = x.getAndShowResult(testInputString, actualOut, expectedOut);
            if(!anyFailed && isFailed)
                anyFailed = true;
        }
        if(anyFailed)
            System.out.println("DONE - TESTS FAILED ❌ some tests did not pass");
        else
            System.out.println("DONE - TESTS PASSED ✅ all tests pass!");
    }
}