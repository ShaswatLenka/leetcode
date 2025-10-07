package solutions.medium;

/*
2008: Maximum Earnings from Taxi [MED]

Dynamic Programming Approach (Thoughts)
Maximum earning we can have picked up all the passengers = 0
Let F(x) = Max earning we can get at xth passenger.
So, we can either choose to pick the xth passenger or choose to skip.
if we are choosing the xth passenger, then we must find out the next possible passenger we can pick. If we are skipping,
then we can pick the next immediate next passenger.
hence max profit = max(profit if we pick xth passenger, profit if we skip xth passenger)
 */

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxTaxiEarnings {

    private long calculateProfit(int[][] rides, int i) {
        int[] passengerInfo = rides[i];
        return (passengerInfo[1] - passengerInfo[0] + passengerInfo[2]);
    }

    private int findNextPassenger(int[][] rides, int endTime, int nextIndex) {
        // Linear search
//        for (int i = nextIndex; i<rides.length; i++) {
//            if (rides[i][0] >= endTime) {
//                return i;
//            }
//        }
//        return rides.length; // we reached the end of the array without finding a next ride

        // Binary search
        int l = nextIndex, r= rides.length;

        while (l < r) {
            int mid = l + (r-l) / 2;
            if (rides[mid][0] < endTime) l = mid + 1;
            else r = mid;
        }
        return r;
    }

    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a,b) -> a[0] - b[0]);
        int l = rides.length;
        long[] dp = new long[l+1];
        dp[l] = 0;

        for (int i = l-1; i>=0; i--) {
            // choose i: if we choose ith passenger, we can only pick the passenger whose starttime >= endtime of ith passenger
            int nextPassengerIndex = findNextPassenger(rides, rides[i][1], i+1);
            dp[i] = Math.max(calculateProfit(rides, i) + dp[nextPassengerIndex], dp[i+1]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        MaxTaxiEarnings m = new MaxTaxiEarnings();
        int n = 20; int[][] rides = {{1,6,1},{3,10,2},{10,12,3},{11,12,2},{12,15,2},{13,18,1}}; // this is already sorted by start time
        int n2 = 10; int[][] rides2 = {{2,3,6}, {8,9,8}, {5,9,7}, {8,9,1}, {2,9,2}, {9,10,6}, {7,10,10}, {6,7,9}, {4,9,7}, {2,3,1}};
        System.out.println(m.maxTaxiEarnings(n,rides));
        System.out.println(m.maxTaxiEarnings(n2,rides2));
    }
}
