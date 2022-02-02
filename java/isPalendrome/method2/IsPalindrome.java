
/*
    Is Palondrome
*/

import java.lang.StringBuffer;


class Solver
{
    private String reverseString(String input)
    {
        return new StringBuffer(input).reverse().toString();
    }

    private boolean stringsEqual(String s1, String s2, boolean caseSensitive)
    {
        if (caseSensitive)
            return s1.equals(s2);
        else
            return s1.toLowerCase().equals(s2.toLowerCase());
    }

    public boolean isPalindrome(String input, boolean caseSensitive)
    {
        String reversedInput = this.reverseString(input);
        return this.stringsEqual(input, reversedInput, caseSensitive);
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
