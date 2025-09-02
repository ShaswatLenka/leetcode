package solutions.medium;

import java.util.Arrays;

/*
* Leetcode 134: Gas Station
*
* Hard to find intuition
* Greedy, Arrays
* */
public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        long sumGas = Arrays.stream(gas).sum();
        long sumCost = Arrays.stream(cost).sum();
        if (sumGas < sumCost) return -1;

        int lastIndex = 0;
        long total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);

            if (total < 0) {
                total = 0;
                lastIndex = i + 1;
            }
        }
        return lastIndex;
    }

    public static void main(String[] args) {
        CanCompleteCircuit c = new CanCompleteCircuit();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(c.canCompleteCircuit(gas, cost));
    }
}
