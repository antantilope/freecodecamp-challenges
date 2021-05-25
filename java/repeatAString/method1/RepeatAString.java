
/*

Repeat a given string str (first argument) for num times (second argument).

This method uses regular expressions.

*/

class Solver {
    public String repreat(String stringToRepeat, int count) {
        // thanks https://howtodoinjava.com/java11/repeat-string-n-times/
        char[] nullChars = new char[count];
        return new String(nullChars).replace("\0", stringToRepeat);
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
