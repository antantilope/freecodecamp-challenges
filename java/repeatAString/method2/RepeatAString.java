
/*

Repeat a given string str (first argument) for num times (second argument).

This method uses bytes

*/

import java.nio.charset.StandardCharsets;


class Solver {
    public String repreat(String stringToRepeat, int count) {
        int stringToRepeatLength = stringToRepeat.length();
        byte[] stringAsBytes = stringToRepeat.getBytes();
        byte[] repeatedBytes = new byte[count * stringToRepeatLength];
        int outIndex = 0;
        while(count-- > 0) {
            for(int i=0; i < stringToRepeatLength; i++){
                repeatedBytes[outIndex] = stringAsBytes[outIndex % stringToRepeatLength];
                outIndex++;
            }
        }
        return new String(repeatedBytes, StandardCharsets.UTF_8);
    }
}


class Main {
    public static void main(String[] args) {
        // Grab input data
        String strintToRepeat = args[0];
        int repeatCount = Math.abs(Integer.parseInt(args[1]));

        Solver solver = new Solver();
        String result = solver.repreat(strintToRepeat, repeatCount);

        System.out.println("Repeating " +  repeatCount + "x times :" + strintToRepeat);
        System.out.println(result);
    }
}
