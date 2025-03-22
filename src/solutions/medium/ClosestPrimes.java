package solutions.medium;
/*
* Leetcode 2523: Closest Prime Numbers in Range
* https://leetcode.com/problems/closest-prime-numbers-in-range/description/
*
* */
import utils.maths.SieveOfEratosthenes;

import java.util.Arrays;

public class ClosestPrimes {
    public static int[] closestPrimes(int left, int right) {
        int[] primes = SieveOfEratosthenes.findPrimesUptoN(right);
        int dist = Integer.MAX_VALUE;
        int start = -1; int end = -1;
        int lastOneIndex = -1; // where was last 1 found
        for (int i = Math.max(left, 2); i <= right; i++) {
           if (primes[i] == 1) {

               // we have found a 1 before
               if (lastOneIndex != -1) {
                   int currDist = i - lastOneIndex;
                   if (currDist < dist) {
                       dist = currDist;
                       start = lastOneIndex;
                       end = i;
                   }
               }
               lastOneIndex = i;
           }
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(closestPrimes(10, 19)));
        System.out.println(Arrays.toString(closestPrimes(4, 6)));
    }
}
