
import java.lang.StringBuffer;


class StringContainer
{
    private String baseString;

    StringContainer(String stringInput) {
        // Constructor to initialize StringContainer instance
        baseString = stringInput;
    }

    public String getBaseString() {
        return baseString;
    }

    public String reverseIt() {
        return new StringBuffer(baseString).reverse().toString();
    }

    public String upperCaseIt() {
        return baseString.toUpperCase();
    }

    public String lowerCaseIt() {
        return baseString.toLowerCase();
    }

}


class Main {
    public static void main(String[] args) {

        // instantiate containers
        StringContainer sc1 = new StringContainer("Hello");
        StringContainer sc2 = new StringContainer("Goodbye");


        //
        System.out.println("container 1 has string " + sc1.getBaseString());
        System.out.println("reverse is " + sc1.reverseIt());
        System.out.println("uppercase is " + sc1.upperCaseIt());

        System.out.println("");

        System.out.println("container 2 has string " + sc2.getBaseString());
        System.out.println("reverse is " + sc2.reverseIt());
        System.out.println("uppercase is " + sc2.upperCaseIt());
        System.out.println("lowercase is " + sc2.lowerCaseIt());
    }
}