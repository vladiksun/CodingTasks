package tasks;

import java.util.*;
import java.util.stream.IntStream;

public class SubLists {

    public static void main(String[] args) {

        // Example usage
        List<Map<String, Object>> bigList = new ArrayList<>();
        IntStream.range(0, 10000).forEach(i -> bigList.add(new HashMap<>()));

        // Assume bigList is populated with your data

        List<List<Map<String, Object>>> splitLists = splitList(bigList, 100);

        System.out.println("Original list size: " + bigList.size());
        System.out.println("Number of sublists: " + splitLists.size());

        for (int i = 0; i < splitLists.size(); i++) {
            System.out.println("Sublist " + (i + 1) + " size: " + splitLists.get(i).size());
        }
    }

    public static List<List<Map<String, Object>>> splitList(List<Map<String, Object>> inputList, int chunkSize) {
        List<List<Map<String, Object>>> result = new ArrayList<>();

        if (inputList == null || inputList.isEmpty()) {
            return result;
        }

        int totalSize = inputList.size();
        for (int i = 0; i < totalSize; i += chunkSize) {
            int end = Math.min(i + chunkSize, totalSize);
            List<Map<String, Object>> subList = inputList.subList(i, end);
            result.add(new ArrayList<>(subList)); // Create new ArrayList to avoid potential issues with subList
        }

        return result;
    }
}
