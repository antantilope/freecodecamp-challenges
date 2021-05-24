

/*
    Return an array consisting of the largest number from each provided sub-array.

    This method leverages the's Collections API as well as the List type.
*/


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;


class Solver {

    private Integer[] intArrayToIntegerArray(int[] primitiveArray) {
        // from https://www.techiedelight.com/convert-int-array-integer-array-java/
        return Arrays.stream(primitiveArray) // IntStream
            .boxed()                        // Stream<Integer>
            .toArray(Integer[]::new);
    }

    private int[] integerListToIntArray(List<Integer> listOfIntegers) {
        int listSize = listOfIntegers.size();
        int[] intArray = new int[listSize];
        for(int i=0; i<listSize; i++)
            intArray[i] = (int) listOfIntegers.get(i);
        return intArray;
    }

    private Integer maxIntArray(int[] arr) {
        /* Given an array of ints, return the max value of the array.
        */
        Integer[] arrIntegers = this.intArrayToIntegerArray(arr);
        List<Integer> listIntegers = Arrays.asList(arrIntegers);
        return Collections.max(listIntegers);
    }

    public int[] findLargestInArray(int[][] outerArray) {
        /* Given an array of int arrays, return a summary int array showing
            the largest element of each inner array.
        */
        List<Integer> largestValuesSummary = new ArrayList<Integer>();
        for(int[] innerArray: outerArray)
            largestValuesSummary.add(this.maxIntArray(innerArray));
        return this.integerListToIntArray(largestValuesSummary);
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
