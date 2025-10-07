package solutions.daily.sept25;

import java.util.HashMap;
import java.util.Map;

public class CanBeTypedWords {
    public int canBeTypedWords(String text, String brokenLetters) {
        Map<Character, Integer> m = new HashMap<>();
        for (Character e: brokenLetters.toCharArray()) {
            m.put(e, 1);
        }
        int ctr = 0;
        boolean flag = false;
        for (String t: text.split(" ")) {
            for (Character c: t.toCharArray()) {
                if (m.containsKey(c)) {
                    flag = true;
                }
            }
            if (!flag) ctr++;
            flag = false;
        }
        return ctr;
    }

    public static void main(String[] args) {
        CanBeTypedWords c = new CanBeTypedWords();
        String inp = "Hello World";
        System.out.println(c.canBeTypedWords(inp, "ad"));
    }
}
