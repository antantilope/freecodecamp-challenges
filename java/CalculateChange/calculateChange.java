

/*
    Task: fill in the VendingMachine::calculateReturnedChange method

    Given:
        > a vending maching makes change by returning
            pennies, nickels, dimes, quarters, and dollar coins.
        > the calculateReturnedChange method accepts 2 arguments
            money owed from customers (represented as # pennies)
            money paid from customers (represented as # pennies)

            the calculateReturnedChange needs needs to create and return
            an instance of ReturnedChange. This data will tell the vending machine
            how many pennies, nickels, dimes, quarters, and dollar coins to return.

            the machine should return the fewest number of coins possible.
            ex: if change is 0.06, dont return 6 pennies. Return 1 nickel and 1 penny.
*/

class ReturnedChange
{
    /* Each instance of this class represent the amount of change
        a vending machine should return for a single transaction.

        example usage: $1.41 cents in change (1 penny, 1 nickel, 1 dime, 1 quarter, 1 dollar coins)
            ReturnedChange rc = new ReturnedChange(1, 1, 1, 1, 1);

            :no change returned:
                ReturnedChange rc = new ReturnedChange(0, 0, 0, 0, 0);
                // or you could write
                ReturnedChange rc = new ReturnedChange();
    */

    static final String NO_CHANGE = "<CHANGE: NONE>";

    private int pennyCount;
    private int nickelCount;
    private int dimeCount;
    private int quarterCount;
    private int dollarCoinCount;

    ReturnedChange(int pennies, int nickels, int dimes, int quarters, int dollars) {
        // Contructor method to setup instance's properties (with change).
        pennyCount = pennies;
        nickelCount = nickels;
        dimeCount = dimes;
        quarterCount = quarters;
        dollarCoinCount = dollars;
    }

    ReturnedChange() {
        // Contructor method to setup instance's properties (no change).
        pennyCount = 0;
        nickelCount = 0;
        dimeCount = 0;
        quarterCount = 0;
        dollarCoinCount = 0;
    }

    public int totalAmountPennies() {
        return (
            this.pennyCount * 1
            + this.nickelCount * 5
            + this.dimeCount * 10
            + this.quarterCount * 25
            + this.dollarCoinCount * 100
        );
    }

    public boolean isNoChange() {
        return (
            this.pennyCount == 0
            && this.nickelCount == 0
            && this.dimeCount == 0
            && this.quarterCount == 0
            && this.dollarCoinCount == 0
        );
    }

    public String toStringRepresentation() {
        if(this.isNoChange())
            return this.NO_CHANGE;

        String[] parts = new String[5];
        parts[0] = "PNY:" + String.valueOf(this.pennyCount);
        parts[1] = "NKL:" + String.valueOf(this.nickelCount);
        parts[2] = "DME:" + String.valueOf(this.dimeCount);
        parts[3] = "QTR:" + String.valueOf(this.quarterCount);
        parts[4] = "DLR:" + String.valueOf(this.dollarCoinCount);
        return "<CHANGE: " + String.join(" ", parts) + " >";
    }
}

class VendingMachine
{
    /* Instances of this class have a calculateReturnedChange method.
        This method accepts 2 values (money owed, and money paid)
        and creates a ReturnedChange instance. The vending machine will use this
        data to issue change to the customer.

    */
    public ReturnedChange calculateReturnedChange(int costInPennies, int paymentInPennies) {

      int totalChangeInPennies = paymentInPennies - costInPennies;
      if(totalChangeInPennies <= 0)
        return new ReturnedChange(); // No change to return.

      // Number of each coin to return to the customer.
      int returnPennyCount = 0;
      int returnNickelCount = 0;
      int returnDimeCount = 0;
      int returnQuarterCount = 0;
      int returnDollarCount = 0;

      // Amount (as pennies) returned to the customer (so far)
      int returnedTotal = 0;

      // Total amount (as pennies) left to return to the customer
      int remainingToReturn;

      while(returnedTotal < totalChangeInPennies)
      {
        remainingToReturn = totalChangeInPennies - returnedTotal;

        if(remainingToReturn >= 100) {
          returnedTotal += 100;
          returnDollarCount++;
          continue;
        }
        if(remainingToReturn >= 25) {
          returnedTotal += 25;
          returnQuarterCount++;
          continue;
        }
        if(remainingToReturn >= 10) {
          returnedTotal += 10;
          returnDimeCount++;
          continue;
        }
        if(remainingToReturn >= 5) {
          returnedTotal += 5;
          returnNickelCount++;
          continue;
        }
        if(remainingToReturn >= 1) {
          returnedTotal += 1;
          returnPennyCount++;
          continue;
        }
      }
      return new ReturnedChange(
        returnPennyCount,
        returnNickelCount,
        returnDimeCount,
        returnQuarterCount,
        returnDollarCount
      );
    }

    // This convenience method is only for testing the code.
    public boolean checkIfFailedAndShowResult(
        int costInPennies,
        int paymentInPennies,
        ReturnedChange output,
        String coins
    ) {
        boolean failed = false;
        int expectedChange = paymentInPennies - costInPennies;
        System.out.println("**********************");
        System.out.println("cost: " + costInPennies);
        System.out.println("paid: " + paymentInPennies);
        System.out.println("expected change: " + expectedChange);
        System.out.println("actual change: " + output.totalAmountPennies());
        System.out.println("expected coin combo: " + coins);
        System.out.println("actual coin combo: " + output.toStringRepresentation());
        if(expectedChange != output.totalAmountPennies())
        {
            System.out.println("❌ unexpected total change amount");
            failed = true;
        }
        else if(!coins.equals(output.toStringRepresentation()))
        {
            System.out.println("❌ unexpected coin combination");
            failed = true;
        } else
            System.out.println("✅ pass");

        System.out.println("**********************");
        return failed;
    }
}



class Main
{
    public static void main(String[] args)
    {
        VendingMachine cokeMachine = new VendingMachine();

        boolean testFailed;
        boolean anyFailed = false;

        // Test 1 // cost 1.00, paid 1.00, no change
        ReturnedChange rc1 = cokeMachine.calculateReturnedChange(100, 100);
        testFailed = cokeMachine.checkIfFailedAndShowResult(100, 100, rc1, ReturnedChange.NO_CHANGE);
        anyFailed = anyFailed || testFailed;

        // Test 2 // cost 1.00, paid 1.41, 0.41 change
        ReturnedChange rc2 = cokeMachine.calculateReturnedChange(100, 141);
        testFailed = cokeMachine.checkIfFailedAndShowResult(100, 141, rc2, "<CHANGE: PNY:1 NKL:1 DME:1 QTR:1 DLR:0 >");
        anyFailed = anyFailed || testFailed;

        // Test 3 // cost 1.79, paid 2.00, 0.21 change
        ReturnedChange rc3 = cokeMachine.calculateReturnedChange(179, 200);
        testFailed = cokeMachine.checkIfFailedAndShowResult(179, 200, rc3, "<CHANGE: PNY:1 NKL:0 DME:2 QTR:0 DLR:0 >");
        anyFailed = anyFailed || testFailed;

        // Test 4 // cost 1.99, paid 2.00, 0.01 change
        ReturnedChange rc4 = cokeMachine.calculateReturnedChange(199, 200);
        testFailed = cokeMachine.checkIfFailedAndShowResult(199, 200, rc4, "<CHANGE: PNY:1 NKL:0 DME:0 QTR:0 DLR:0 >");
        anyFailed = anyFailed || testFailed;

        // Test 5 // cost 4.59, paid 5.00, 0.41 change
        ReturnedChange rc5 = cokeMachine.calculateReturnedChange(459, 500);
        testFailed = cokeMachine.checkIfFailedAndShowResult(459, 500, rc5, "<CHANGE: PNY:1 NKL:1 DME:1 QTR:1 DLR:0 >");
        anyFailed = anyFailed || testFailed;

        // Test 6 // cost 14.21, paid 20.00, 5.79 change
        ReturnedChange rc6 = cokeMachine.calculateReturnedChange(1421, 2000);
        testFailed = cokeMachine.checkIfFailedAndShowResult(1421, 2000, rc6, "<CHANGE: PNY:4 NKL:0 DME:0 QTR:3 DLR:5 >");
        anyFailed = anyFailed || testFailed;

        // End of tests.
        if(anyFailed)
            System.out.println("DONE - TESTS FAILED ❌ some tests did not pass");
        else
            System.out.println("DONE - TESTS PASSED ✅ all tests pass!");

    }
}
