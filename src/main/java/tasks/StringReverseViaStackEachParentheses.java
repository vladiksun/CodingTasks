package tasks;

import java.util.Stack;

// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/
public class StringReverseViaStackEachParentheses {

    public static void main(String[] args) {
        //var test = "([{}])";
        var test = "(u(love)i)";

        var result = reverseParentheses(test);

        System.out.println(result);
    }

    public static String reverseParentheses(String test) {
        var stack = new Stack<Character>();

        var result = "";

        for (int i = 0; i < test.length(); i++) {
            // push to stack all chars until we meet ')'
            if (test.charAt(i) != ')') {
                stack.push(test.charAt(i));
            } else {
                while (stack.peek() != '(') {
                    result = result + stack.pop();
                }
                stack.pop();

                for (int j = 0; j < result.length(); j++) {
                    stack.push(result.charAt(j));
                }
                result = "";
            }
        }
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }

}
