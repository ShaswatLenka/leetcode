package solutions.hard;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 502: IPO
 * https://leetcode.com/problems/ipo/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class FindMaximizedCapital {
    class Project implements Comparable<Project> {
        int capital, profit;
        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
        public int compareTo(Project project) {
            return capital - project.capital; // less capital means less value (more preference in sorting ascending)
        }

    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];
        for (int i = 0; i<n; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }
        Arrays.sort(projects); // this will sort in increasing order of capital required.
        // Max Heap
        PriorityQueue<Integer> q = new PriorityQueue<>(n, Collections.reverseOrder());

        int ptr = 0;
        for (int i = 0; i<k; i++) {

            // add project's profit to the queue if it can be done with the current capital
           while(ptr < n && w >= projects[ptr].capital) {
              q.add(projects[ptr++].profit);
           }

            if (q.isEmpty()) {
                break;
            }

           // take the highest profit and add it to ans
            w += q.poll();
        }
        return w;
    }

    public static void main(String[] args) {
        FindMaximizedCapital f = new FindMaximizedCapital();
        int k = 2, w = 0;
        int[] profits = {1,2,3};
        int[] capital = {0,1,1};
        System.out.println(f.findMaximizedCapital(k, w, profits, capital));
    }
}
