
/*
    Given: A payphone's cost is calculated as such:
        $0.25 for the first 3 minutes
        $0.10 for each additional minute that follows, up to 10 minutes

        example costs:
            1 min: 0.25
            2 min: 0.25
            (up to + incl) 3 min: 0.25
            (up to + incl) 4 min: 0.35
            (up to + incl) 5 min: 0.45
            (up to + incl) 6 min: 0.55
            (up to + incl) 7 min: 0.65
            (up to + incl) 8 min: 0.75
            (up to + incl) 9 min: 0.85
            (up to + incl) 10 min: 0.95

    Task: fill in the calculateSecondsRemaining method
        this method takes 2 arguments
            - number of seconds the customer has been on the call for
            - number of cents the customer paid
        goal: given these 2 inputs, calculate how many more seconds the customer
            can use the phone before more money must be added OR the phone call is ended.
            If zero time or negative time is remaining, return 0.
            calls should automatically end after 10 minutes.
*/




class Payphone
{
    public int calculateSecondsRemaining(int secondsOnCall, int amountPaidCents)
    {
        // Fill in this method
        return -1;
    }
}


class Main
{


    public static boolean checkAnswer(int secondsOnCall, int amountPaidCents, int actual, int expected)
    {
        System.out.println("*******************************");
        System.out.println("secondsOnCall: " + Integer.toString(secondsOnCall));
        System.out.println("amountPaidCents: " + Integer.toString(amountPaidCents));
        System.out.println("actual seconds remaining: " + Integer.toString(actual));
        System.out.println("expected seconds remaining: " + Integer.toString(expected));

       boolean failed = expected != actual;
        if(failed)
            System.out.println("❌ fail");
        else
            System.out.println("✅ pass");
        System.out.println("*******************************");
        return failed;
    }


    public static void main(String[] args)
    {
        Payphone pp = new Payphone();

        int[][] tests = {
            {0, 10, 0},     // on for 0, paid for 0, 0 seconds left.
            {10, 10, 0},    // on for 10, paid for 0, 0 seconds left.
            {60, 25, 120},  // on for 60, paid for 180, 120 seconds left.
            {85, 25, 95},   // on for 85, paid for 180, 95 seconds left.
            {0, 35, 240},   // on for 0, paid for 240, 240 seconds left.
            {210, 35, 30},  // on for 210, paid for 240, 30 seconds left.
            {210, 40, 30},  // on for 210, paid for 240, 30 seconds left.
            {210, 55, 150}, // on for 210, paid for 360, 150 seconds left.
            {585, 95, 15},  // on for 585, paid for 600 (max), 15 seconds left.
            {599, 95, 1},   // on for 599, paid for 600 (max), 1 seconds left.
            {599, 150, 1},  // on for 599, overpaid for 600 (max), 1 seconds left.
            {600, 150, 0},  // on for 600, overpaid for 600 (max), 0 seconds left.
            {650, 150, 0},  // on for 650, overpaid for 600 (max), 0 seconds left.
            {300, 25, 0},   // on for 300, paid for 180, 0 seconds left (negative time).
        };
        int actual;
        boolean failed;
        boolean anyFailed = false;

        for(int[] test: tests){
            actual = pp.calculateSecondsRemaining(test[0], test[1]);
            failed = checkAnswer(test[0], test[1], actual, test[2]);
            anyFailed = anyFailed || failed;
        }

        if(anyFailed)
            System.out.println("DONE - TESTS FAILED ❌ some tests did not pass");
        else
            System.out.println("DONE - TESTS PASSED ✅ all tests pass!");
    }
}

