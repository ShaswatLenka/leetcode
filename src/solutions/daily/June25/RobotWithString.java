package solutions.daily.June25;

import java.util.Stack;

public class RobotWithString {
    public String robotWithString(String s) {
        int[] chars = new int[26];
        StringBuilder res = new StringBuilder();
        for (char c: s.toCharArray()) {
            chars[c - 'a']++;
        }
        Stack<Character> t = new Stack<>();
        char minChar = 'a';
        for(char c: s.toCharArray()) {
            t.push(c);
            chars[c - 'a']--;
            // find minimum character in the rest of the string
            while(minChar != 'z' && chars[minChar - 'a'] == 0) {
                minChar++;
            }
            // pop sequence
            while(!t.isEmpty() && t.peek() <= minChar) {
                res.append(t.pop());
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        RobotWithString r = new RobotWithString();
        System.out.println(r.robotWithString("bdda"));
    }
}
