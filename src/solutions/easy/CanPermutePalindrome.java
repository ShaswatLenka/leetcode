package solutions.easy;
import java.util.*;
public class CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        int lengthOfString = s.length();
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        int numOdd = 0;
        for (Map.Entry<Character, Integer> entry : m.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                numOdd++;
            }
        }
        return (lengthOfString % 2 == 0 && numOdd == 0) || lengthOfString % 2 != 0 && numOdd == 1;
    }

    public static void main(String[] args) {
        CanPermutePalindrome c = new CanPermutePalindrome();
        System.out.println(c.canPermutePalindrome("code"));
        System.out.println(c.canPermutePalindrome("carerac"));
    }
}
