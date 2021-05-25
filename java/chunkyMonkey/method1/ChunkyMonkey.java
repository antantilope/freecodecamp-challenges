

/*
    Write a function that splits an array (first argument) into groups the length of size (second argument) and returns them as a two-dimensional array.


    TODO: dont allow zeros:
        Chunk Size: 3 Sample data: [43, 64, 352123, 746, 8675, 8756, 654, 45456, 654, 33]
        Result: [[43, 64, 352123], [746, 8675, 8756], [654, 45456, 654], [33, 0, 0]]
*/


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


class Solver {

    private int[][] listOfIntArraysToArrayOfArrays(List<int[]> input, int chunckSize) {
        int listSize = input.size();
        int[][] output = new int[listSize][chunckSize];
        for(int i = 0; i< listSize; i++)
            output[i] = input.get(i);
        return output;
    }

    public int[][] chunkArray(int[] arr, int chunckSize) {
        int arrayLength = arr.length;
        List<int[]> out = new ArrayList<int[]>();
        for(int i = 0; i < arrayLength; i = i + chunckSize)
            out.add(Arrays.copyOfRange(arr, i, i + chunckSize));
        return this.listOfIntArraysToArrayOfArrays(out, chunckSize);
    }
}

class Main {
    public static void main(String[] args) {
        int[] exampleData = {43,64,352123,746,8675,8756,654,45456,654, 33};
        int chunckSize = 3;
        Solver solver = new Solver();
        int[][] result = solver.chunkArray(exampleData, chunckSize);

        System.out.println("Chunk Size: " + chunckSize + " Sample data: " + Arrays.toString(exampleData));
        System.out.println("Result: " + Arrays.deepToString(result));
    }

}
