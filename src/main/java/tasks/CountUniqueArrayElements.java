package tasks;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.reducing;

public class CountUniqueArrayElements {
    public static void main(String[] args) {

        int[] arr = {1,1,2,2,3,4};

        // Get only unique ints from the array
        int[] ints = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(c -> c, reducing(0, e -> 1, Integer::sum)))
                .entrySet()
                .stream()
                .filter(integerIntegerEntry -> integerIntegerEntry.getValue() == 1)
                .mapToInt(Map.Entry::getKey)
                .toArray();

        Arrays.stream(ints).forEach(System.out::println);

    }
}
