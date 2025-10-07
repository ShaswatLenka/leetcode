package solutions.daily.sept25;

/*
3541: Find most frequent vowel and consonant [EASY]
 */


import java.util.HashMap;
import java.util.Map;

public class MaxFreqSum {

    private boolean isVowel(Character c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }

    public int maxFreqSum(String s) {
        int vowels = 0, consonants = 0;
        Map<Character, Integer> m = new HashMap<>();
        for (Character c: s.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> e: m.entrySet()) {
           if (isVowel(e.getKey())) {
               if (e.getValue() > vowels) vowels = e.getValue();
           } else {
               if (e.getValue() > consonants) consonants = e.getValue();
           }
        }
        return vowels + consonants;
    }
}
