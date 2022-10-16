package ga.repin.education.course02.topic06.hw;

import java.util.*;

public class Hw06 {
    public static void main() {
        listOfOddNumbers();
        listOfEvenASC();
        printListOfUnicalWords();
        printDoubleWordCountFromList();
    }

    public static void listOfOddNumbers() {
        System.out.println("Задача 1:");
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        nums.removeIf(n -> !(n % 2 == 1));
        System.out.println(nums);
    }

    public static void listOfEvenASC() {
        System.out.println("Задача 2:");
        List<Integer> nums = new ArrayList<>(List.of(8, 1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        Set<Integer> set = new HashSet<>(nums);
        set.removeIf(n -> !(n % 2 == 0));
        nums = new ArrayList<>(set);
        Collections.sort(nums);
        System.out.println(nums);
    }

    public static void printListOfUnicalWords() {
        System.out.println("Задача 3:");
        List<String> inputWordList = new ArrayList<>(List.of("one", "two", "three", "two", "one", "one", "three", "one", "two"));
        Set<String> result = new HashSet<>(inputWordList);
        System.out.println(result);
    }

    public static void printDoubleWordCountFromList() {
        System.out.println("Задача 4:");
        List<String> inputWordList = new ArrayList<>(List.of("one", "two", "three", "two", "one", "one", "three", "one", "two"));
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : inputWordList) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            if (entry.getValue() == 1) {
                wordMap.remove(entry);
            }
        }
        System.out.println(wordMap.values());

    }
}
