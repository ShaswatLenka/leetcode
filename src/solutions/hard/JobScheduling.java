package solutions.hard;

import java.util.*;

/**
 * 1235: Maximum Profit in Job Scheduling
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
 *
 * You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
 *
 * If you choose a job that ends at time X you will be able to start another job that starts at time X
 */
public class JobScheduling {

    private int findNextJob(int[] startTime, int endTimeOfCurrentJob) {
        int l = -1, r = startTime.length;
        // we have to find the first start time that is greater than or equal to endTimeOfCurrentJob
        while(r > l+1) {
            int mid = (l + r) / 2;
            if (startTime[mid] >= endTimeOfCurrentJob) r = mid;
            else l = mid;
        }
        return r;
    }

    private int findMaxProfit(List<List<Integer>> jobs, int[] startTime) {
        int length = startTime.length;
        int[] dp = new int[length+1];

        // base case
        dp[length] = 0; // profit of starting at length = 0 because we cannot schedule any job

        for (int position = length - 1; position >= 0; position--) {
            int currProfit = 0; // profit made by scheduling current job
            int profitAtPosition = jobs.get(position).get(2);

            // nextIndex is the index of next non-conflicting job
            int nextIndex = findNextJob(startTime, jobs.get(position).get(1)); // pass end time of current job

            // if a non-conflicting job is possible, then only add its profit
            if (nextIndex != length) {
                currProfit = profitAtPosition + dp[nextIndex];
            } else {
                currProfit = profitAtPosition;
            }

            // take max of both cases (schedule the job or skip it)
            dp[position] = Math.max(currProfit, dp[position + 1]);
        }

        return dp[0];
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();

        // zip startTime, endTime and profit to a single array
        for (int i = 0; i<profit.length; i++) {
            List<Integer> currJob = new ArrayList<>();
            currJob.add(startTime[i]);
            currJob.add(endTime[i]);
            currJob.add(profit[i]);

            jobs.add(currJob);
        }

        // sort them by start time
        jobs.sort(Comparator.comparingInt(sortKey -> sortKey.get(0)));

        // store startTime in a separate list (will be used for binary search later)
        for (int i = 0; i<jobs.size(); i++) {
            startTime[i] = jobs.get(i).get(0);
        }

        return findMaxProfit(jobs, startTime);
    }

    public static void main(String[] args) {
        JobScheduling j = new JobScheduling();
        int[] startTime = {1,2,3,4,6}, endTime = {3,5,10,6,9}, profit = {20, 20, 100, 70, 60};
        System.out.println(j.jobScheduling(startTime, endTime, profit));
    }
}
