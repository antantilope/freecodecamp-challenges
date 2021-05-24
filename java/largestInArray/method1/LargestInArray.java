

/*
    Return an array consisting of the largest number from each provided sub-array.

    This method only uses primative ints and arrays.
*/


import java.util.Arrays;

class Solver {
    public int maxIntArray(int[] arr) {
        /* Given an array of ints, return the max value of the array.
        */

        int arrayLengh = arr.length;
        if(!(arrayLengh > 0))
            return 0; // If array is empty, return 0.

        int maxValue = 0;
        for(int i = 0; i < arrayLengh; i++) {
            if (i == 0 || arr[i] > maxValue)
                maxValue = arr[i];
        }
        return maxValue;
    }

    public int[] findLargestInArray(int[][] outerArray) {
        /* Given an array of int arrays, return a summary int array showing
            the largest element of each inner array.
        */

        int outerArrayLength = outerArray.length;
        int[] largestArrayValues = new int[outerArrayLength];
        for(int i=0; i<outerArrayLength; i++)
            largestArrayValues[i] = this.maxIntArray(outerArray[i]);
        return largestArrayValues;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] exampleData = {
            {4,7,2,6,8,23,63,3,6},
            {4,3,5,2,9,3,12,-15},
            {43,64,352123,746,8675,8756,654,45456,654},
        };
        Solver solver = new Solver();
        int[] result = solver.findLargestInArray(exampleData);

        System.out.println("Sample data: " + Arrays.deepToString(exampleData));
        System.out.println("Result: " + Arrays.toString(result));
    }

}
