package solutions.daily.sept25;

/* 3495: Minimum Operations to make Array Elements Zero [HARD]

You are given a 2D array queries, where queries[i] is of the form [l, r]. Each queries[i] defines an array of integers nums consisting of elements ranging from l to r, both inclusive.

In one operation, you can:

    Select two integers a and b from the array.
    Replace them with floor(a / 4) and floor(b / 4).

Your task is to determine the minimum number of operations required to reduce all elements of the array to zero for each query. Return the sum of the results for all queries.
 */

public class MinOperations {
    /*
        Get the sum of minimum number of operations for all numbers from [1,num]
     */
    private long getCount(int num){
        int bits = 1;
        long cnt = 0;
        int base = 1;
        while (base <= num) {
            int end = Math.min(2*base - 1, num);
            cnt += (long) ((bits+1)/2)*(end - base + 1); // + 1 is for the ceil operation
            bits++;
            base *= 2;
        }
        return cnt;
    }
    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] k: queries) {
           long countTillR = getCount(k[1]);
           long countTillBeforeL = getCount(k[0] - 1);
           ans += (countTillR - countTillBeforeL + 1)/2; // + 1 is for the ceil operation
        }
        return ans;
    }

    public static void main(String[] args) {
        MinOperations m = new MinOperations();
        int[][] queries = {{1,2}, {2,4}, {2,6}};
        int[][] queries1 = {{1,2}, {2,4}};
        System.out.println(m.minOperations(queries1));
    }

}
