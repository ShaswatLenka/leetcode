package solutions.easy;
/**
 * Leetcode 2379: Minimum recolors to get k consecutive black blocks
 */

public class MinRecolors {
    public static int minimumRecolors(String blocks, int k) {
        int start = 0, end = k;
        int maxBlacks = 0;
        for (int i = start; i < end; i++) {
            if (blocks.charAt(i) == 'B') {
                maxBlacks++;
            }
        }
        int currBlacks = maxBlacks;
        while (end < blocks.length()) {
            if (blocks.charAt(start) == 'W' && blocks.charAt(end) == 'B') {
                currBlacks++;
            }
            if (blocks.charAt(start) == 'B' && blocks.charAt(end) == 'W') {
                currBlacks --;
            }
            if (currBlacks > maxBlacks) {
                maxBlacks = currBlacks;
            }
            start++; end++;
        }
        return k - maxBlacks;
    }

    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBBWWBBWBW", 7));
        System.out.println(minimumRecolors("WBWBBBW", 2));
        System.out.println(minimumRecolors("WBB", 1));
    }
}
