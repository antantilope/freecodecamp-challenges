
/*
    Is Palendrome
*/


class Solver
{
    public boolean isPalendrome(String input)
    {
        // Add code here
    }
}


class Main {
    public static void main(String[] args) {
        Solver s = new Solver();

        String[] inputsToTest = {
            "hello world!",
            "FooBar",
            "racecar",
            "derp",
            "Racecar",
            "won ton not now",
            "cheese cat",
        };

        for(String testString: inputsToTest) {
            if (s.isPalendrome(testString)) {
                System.out.println(testString + " is a palendrome");
            }
            else {
                System.out.println(testString + " is NOT a palendrome");
            }
        }
    }
}
