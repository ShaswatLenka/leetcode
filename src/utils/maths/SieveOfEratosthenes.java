package utils.maths;

import java.util.Arrays;

public class SieveOfEratosthenes {
    public static int[] findPrimesUptoN(int n) {
        // Time Complexity: O(N*log(log(N))), Space Complexity: O(N)
        int[] primes = new int[n+1];
        Arrays.fill(primes, 1);
        for (int i = 2; i*i <= n; i++) { // for every prime, we only need to start checking from i*i
            if (primes[i] == 1) {
               for (int j = i*i; j<=n; j += i) {
                  primes[j] = 0;
               }
            }
        }
        return primes;
    }
}
