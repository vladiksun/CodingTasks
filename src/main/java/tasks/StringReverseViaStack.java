package tasks;

import java.util.Stack;

public class StringReverseViaStack {

    public static void main(String[] args) {
        String s = reverse("1234");

        System.out.println(s);
    }

    static String reverse(String str) {
        var stack = new Stack<Character>();

        var result = "";

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        while (!stack.isEmpty()) {
            char ch = stack.pop();
            result = result + ch;
        }

        return result;
    }

}
