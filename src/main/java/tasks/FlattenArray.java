package tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FlattenArray {

    public static void main(String[] args) {
        var testArr = new Object[]{
                1,
                2,
                new Object[]{ 3, 4,
                        new Object[]{ 5, 6 }
                },
                7
        };

        List flatten = flatten(testArr);
        System.out.println(flatten);
    }

    static List flatten(Object[] arr) {
        var result = new ArrayList<>();

        var stack = new Stack<Object[]>();

        var temp = arr;

        while (temp != null) {
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] instanceof Object[] asArr) {
                    stack.push(asArr);
                } else {
                    result.add(temp[i]);
                }
            }

            if (!stack.isEmpty()) {
                temp = stack.pop();
            } else {
                temp = null;
            }
        }

        return result;
    }

}
