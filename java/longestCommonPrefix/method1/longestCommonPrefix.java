
import java.util.Arrays;

class Solution {

    public String longestCommonPrefix(String[] strs)
    {
        // Add code here
        return "";
    }
}

class Main
{
    public static void printArrayOfStrings(String prefix, String[] arr)
    {
        System.out.println(prefix + ": " + Arrays.toString(arr));
    }

    public static boolean checkAnswer(String[] testData, String output, String expected)
    {
        System.out.println("*******************************");
        printArrayOfStrings("test data", testData);
        System.out.println("output: " + output);
        System.out.println("expected: " + expected);

       boolean failed = !expected.equals(output);
        if(failed)
            System.out.println("❌ fail");
        else
            System.out.println("✅ pass");
        System.out.println("*******************************");
        return failed;
    }

    public static void main(String[] args)
    {
        boolean anyFailed = false;
        boolean failed;
        Solution s = new Solution();

        String[] test1 = {"hello", "world"};
        String test1Output = s.longestCommonPrefix(test1);
        failed = checkAnswer(test1, test1Output, "");
        anyFailed = anyFailed || failed;

        String[] test2 = {"hello"};
        String test2Output = s.longestCommonPrefix(test2);
        failed = checkAnswer(test2, test2Output, "hello");
        anyFailed = anyFailed || failed;

        String[] test3 = {"abcd", "abcd"};
        String test3Output = s.longestCommonPrefix(test3);
        failed = checkAnswer(test3, test3Output, "abcd");
        anyFailed = anyFailed || failed;

        String[] test4 = {"abcdef", "abcd", "abcdehhhh"};
        String test4Output = s.longestCommonPrefix(test4);
        failed = checkAnswer(test4, test4Output, "abcd");
        anyFailed = anyFailed || failed;

        String[] test5 = {"foodfight", "foodfail", "foodf"};
        String test5Output = s.longestCommonPrefix(test5);
        failed = checkAnswer(test5, test5Output, "foodf");
        anyFailed = anyFailed || failed;

        String[] test6 = {"taco-bell", "taco-belarus", "taco-baller"};
        String test6Output = s.longestCommonPrefix(test6);
        failed = checkAnswer(test6, test6Output, "taco-b");
        anyFailed = anyFailed || failed;

        String[] test7 = {"1234567891011", "12345678", "123455678", "1234567891011", "12345678"};
        String test7Output = s.longestCommonPrefix(test7);
        failed = checkAnswer(test7, test7Output, "12345");
        anyFailed = anyFailed || failed;

        String[] test8 = {"1234567891011", "12345678", "123455678", "666777888", "12345678"};
        String test8Output = s.longestCommonPrefix(test8);
        failed = checkAnswer(test8, test8Output, "");
        anyFailed = anyFailed || failed;

        if(anyFailed)
            System.out.println("DONE - TESTS FAILED ❌ some tests did not pass");
        else
            System.out.println("DONE - TESTS PASSED ✅ all tests pass!");

    }

}