
/*

Repeat a given string str (first argument) for num times (second argument).

This method uses regular expressions.

*/

class Solver {
    public String solve(String stringToRepeat, int count) {
        // thanks https://howtodoinjava.com/java11/repeat-string-n-times/
        return new String(new char[count]).replace("\0", stringToRepeat);
    }
}


class Main {
    public static void main(String[] args) {
        // Grab input data
        String exampleString = args[0];
        int exampleCount = Integer.parseInt(args[1]);

        Solver solver = new Solver();
        String result = solver.solve(exampleString, exampleCount);

        System.out.println("Repeating " +  exampleCount + "x times :" + exampleString);
        System.out.println(result);
    }
}
