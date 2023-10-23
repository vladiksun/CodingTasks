package tasks;

import java.util.*;

public class FlattenArray {

    public static void main(String[] args) {
        var testArr = new Object[]{
                1,
                2,
                new Object[]{ 3, 4,
                        new Object[]{ 5, 6 }, 7
                },
                8
        };

        List flatten = flatten(testArr);
        System.out.println(flatten);
    }

    static List flatten(Object[] arr) {
        var result = new LinkedList();

        var stack = new Stack();
        stack.push(arr);

        while (!stack.isEmpty()) {
            var next = stack.pop();

            if (next instanceof Object[] asArr) {
                for (int i = 0; i < asArr.length; i++) {
                    stack.push(asArr[i]);
                }
            } else {
                result.addFirst(next);
            }

        }

        return result;
    }
}
