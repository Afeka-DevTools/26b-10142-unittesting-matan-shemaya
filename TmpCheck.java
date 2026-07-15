import java.util.*;
public class TmpCheck {
    public static void main(String[] args) {
        String text = "!!!";
        String[] words = text.toLowerCase().split("\\W+");
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        try {
            System.out.println(Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey());
        } catch (Throwable t) {
            System.out.println(t.getClass().getName());
        }
    }
}
