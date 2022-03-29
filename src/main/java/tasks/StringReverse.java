package tasks;

public class StringReverse {

    public static void main(String[] args) {
        String s = recursiveMethod("1234");
        System.out.println(s);
    }

    static String recursiveMethod(String str) {
        if ((null == str) || (str.length() <= 1)) {
            return str;
        }

        return recursiveMethod(str.substring(1)) + str.charAt(0);
    }

}
