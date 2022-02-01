
/*
    Is Palondrome
*/


class Solver
{
    public boolean isPalindrome(String input, boolean caseSensitive)
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
            "abBa",
        };

        // Check for case insensitive palindromes
        for(String testString: inputsToTest) {
            if (s.isPalindrome(testString, false)) {
                System.out.println(testString + " is a palindrome (case insensitive)");
            }
            else {
                System.out.println(testString + " is NOT a palindrome (case insensitive)");
            }
        }

        // Check for case sensitive palindromes
        for(String testString: inputsToTest) {
            if (s.isPalindrome(testString, true)) {
                System.out.println(testString + " is a palindrome (case sensitive)");
            }
            else {
                System.out.println(testString + " is NOT a palindrome (case sensitive)");
            }
        }

    }
}
