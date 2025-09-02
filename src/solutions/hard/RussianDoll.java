package solutions.hard;

/**
 * Leetcode 354: Russian Doll Envelopes
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
 * One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
 * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 * Note: You cannot rotate an envelope.
 *
 *
 */
public class RussianDoll {
    public int maxEnvelopes(int[][] envelopes) {
        return 0;
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        RussianDoll r = new RussianDoll();
        System.out.println(r.maxEnvelopes(envelopes));
    }
}
