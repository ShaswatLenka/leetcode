package solutions.easy;

/** Leetcode 392: Is Subsequence
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of
 * the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int ptr1 = 0;
        if (s.length() == 0) return true;
        for (int i = 0; i<t.length(); i++) {
            if(s.charAt(ptr1) == t.charAt(i)) {
                ptr1++;
            }
            if (ptr1 == s.length()) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IsSubsequence sol = new IsSubsequence();
        String s="abc", t="ahbgdc";
        System.out.println(sol.isSubsequence(s, t));
    }
}
