
/*
    Return the provided string with the first letter of each word capitalized.
    Make sure the rest of the word is in lower case.
    For the purpose of this exercise, you should also capitalize connecting words like "the" and "of".

    "hello world" => "Hello World"

*/


class Solver {
    public String titleCase(String input) {
        String[] words = input.split(" ");
        for(int i = 0; i < words.length; i++) {
            String upperCasedPart = words[i].substring(0, 1).toUpperCase();
            String lowerCasedPart = words[i].substring(1).toLowerCase();
            words[i] = upperCasedPart + lowerCasedPart;
        }
        return String.join(" ", words);
    }
}


class Main {
    public static void main(String[] args) {

        String[] inputsToTest = {
            "lorum ipsum du hast",
            "The lazy brown fox",
            "dErPy FlErPY",
            "won ton not now",
        };

        String result;
        Solver solver = new Solver();
        for(String testString: inputsToTest) {
            result = solver.titleCase(testString);
            System.out.println("original: " +  testString);
            System.out.println("result: " +  result);
        }
    }
}
