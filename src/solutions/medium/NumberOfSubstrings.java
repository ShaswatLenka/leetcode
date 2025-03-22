package solutions.medium;

/**
 * Leetcode 1358: Number of substrings containing all three characters
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/?envType=daily-question&envId=2025-03-11
 */
public class NumberOfSubstrings {
    public int numberOfSubstrings(String s) {
        int[] freq = new int[3];
        int count = 0;
        int left = 0; int right = 0;
        int len = s.length();
        while(right < len) {
            // get current character from right and add it to freq array
            char curr = s.charAt(right);
            freq[curr - 'a'] ++; // we can do this because the string s can only have 3 characters 'a', 'b' and 'c'
            while(hasAllChars(freq)) {
                count += len - right;
                char leftChar = s.charAt(left);
                freq[leftChar - 'a'] --;
                left++;
            }
            right++;
        }
        return count;
    }

    private boolean hasAllChars(int[] freq) {
        return freq[0] > 0 && freq[1] > 0 && freq[2] > 0;
    }

    public static void main(String[] args) {
        NumberOfSubstrings n = new NumberOfSubstrings();
        System.out.println(n.numberOfSubstrings("abcabc"));
        System.out.println(n.numberOfSubstrings("aaacb"));
    }
}
