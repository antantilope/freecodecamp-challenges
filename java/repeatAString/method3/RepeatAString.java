
/*

Repeat a given string str (first argument) for num times (second argument).

This method uses char arrays

*/




class Solver {
    public String repreat(String stringToRepeat, int count) {
        char[] charArrayToRepreat = stringToRepeat.toCharArray();
        int repeatStringLength = stringToRepeat.length();
        char[] outChars = new char[repeatStringLength * count];
        int outIndex = 0;
        while(count-- > 0) {
            for(int i=0; i < repeatStringLength; i++){
                outChars[outIndex] = charArrayToRepreat[outIndex % repeatStringLength];
                outIndex++;
            }
        }
        return new String(outChars);

    }
}


class Main {
    public static void main(String[] args) {
        // Grab input data
        String strintToRepeat = args[0];
        int repeatCount = Integer.parseInt(args[1]);

        Solver solver = new Solver();
        String result = solver.repreat(strintToRepeat, repeatCount);

        System.out.println("Repeating " +  repeatCount + "x times :" + strintToRepeat);
        System.out.println(result);
    }
}
