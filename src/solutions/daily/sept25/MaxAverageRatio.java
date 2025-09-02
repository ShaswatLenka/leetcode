package solutions.daily.sept25;


import java.util.PriorityQueue;

/*
1792: Maximum Average Pass Ratio
 */
public class MaxAverageRatio {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a,b) -> Double.compare(b[0], a[0]));

        /* Initialize:
         We keep track of the anticipated delta for gain in pass ratio for every class
         if an extra student is added (without changing the actual passes and totalStudents)
         */
        for (int[] singleClass: classes) {
            int passes = singleClass[0];
            int totalStudents = singleClass[1];
            double gain = calculateGain(passes, totalStudents);
            maxHeap.offer(new double[]{gain, passes, totalStudents});
        }

        /* Distribute extra students
         We take a decision based on the anticipated delta, but this time, we change the real passes and totalStudents
         i.e. assign the student to the class. (and update the anticipated delta for this particular class)
         */

        while(extraStudents-- > 0) {
            double[] current = maxHeap.poll();
            int passes = (int) current[1];
            int totalStudents = (int) current[2];
            maxHeap.offer(new double[] {calculateGain(passes+1, totalStudents+1), passes + 1, totalStudents + 1});
        }

        // calculate final max average pass ratios
        double sumOfPassRatios = 0;
        while(!maxHeap.isEmpty()) {
           double[] curr = maxHeap.poll();
           int passes = (int) curr[1];
           int totalStudents = (int) curr[2];
           sumOfPassRatios += (double) passes/totalStudents;
        }
        return sumOfPassRatios/classes.length;
    }

    private double calculateGain(int passes, int totalStudents) {
        return ((double) (passes + 1) / (totalStudents + 1) - (double) passes/totalStudents);
    }

    public static void main(String[] args) {
        MaxAverageRatio m = new MaxAverageRatio();
        int[][] classes = {{1,2}, {3,5}, {2,2}}; int extraStudents = 4;
        int[][] classes2 = {{2,4}, {3,9}, {4,5}, {2,10}};
        System.out.println(m.maxAverageRatio(classes2, extraStudents));
    }
}
