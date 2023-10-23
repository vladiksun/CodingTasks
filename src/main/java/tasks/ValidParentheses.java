package tasks;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        //var test = "([{}])";
        var test = "[{}])";

        boolean isValid = isValid(test);

        System.out.println(isValid);
    }

    static boolean isValid(String test) {
        var isValid = false;

        var stack = new Stack<Character>();

        for (int i = 0; i < test.length(); i++) {
            char ch = test.charAt(i);
            switch (ch) {
                case '{', '[', '(':
                    stack.push(ch);
                    break;
                case '}', ']', ')':
                    if (!stack.isEmpty()) {
                        char chl = stack.pop();
                        if ((chl == '{' && ch == '}')
                            || (chl == '(' && ch == ')')
                            || (chl == '[' && ch == ']')
                        ) {
                            isValid = true;
                        } else {
                            isValid = false;
                        }
                    } else {
                        isValid = false;
                    }
                    break;
                default:
                    break;
            }
        }

        return isValid;
    }
}
