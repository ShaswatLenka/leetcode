package solutions.daily.sept25;

/*
Leetcode 3025: Find Number of ways to place people I
You are given a 2D array points of size n x 2 representing integer coordinates of some points on a 2D plane,
where points[i] = [xi, yi].

Count the number of pairs of points (A, B), where

   1. A is on the upper left side of B, and
   2. there are no other points in the rectangle (or line) they make (including the border).

Return the count.

Topic: Array Math Geometry Sorting Enumeration
 */

public class NumberOfPairs {
    public int numberOfPairs(int[][] points) {
        // Since 2 <= n <= 50, we can brute force it for every pair and then just check for the conditions above
        int n = points.length;
        int ans = 0;
        for (int i = 0; i<n-1; i++) {
            for (int j = i+1; j<n; j++) {
                boolean isTopLeft = checkTopLeft(points[i], points[j]);
                if (isTopLeft) {
                    boolean isPointInsideRect = false;
                    for (int k = 0; k<n; k++) {
                        if (k != i && k != j) {
                            if (checkRectangle(points[i], points[j], points[k])) {
                                isPointInsideRect = true;
                                break;
                            }
                        }
                    }
                    if (!isPointInsideRect) ans += 1;
                }
            }
        }
        return ans;
    }

    private boolean checkTopLeft(int[] p, int[] q) {
        int x1 = p[0], y1 = p[1];
        int x2 = q[0], y2 = q[1];
        if ((x1 < x2 && y1 >= y2) || (x1 <= x2 && y1 > y2)) return true;
        if ((x2 < x1 && y2 >= y1) || (x2 <= x1 && y2 > y1)) return true;
        else return false;
    }

    private boolean checkRectangle(int[] p, int[] q, int[] r) {
       // check if r lies in the rectangle formed by p and q
        int x1 = p[0], y1 = p[1];
        int x2 = q[0], y2 = q[1];
        int x3 = r[0], y3 = r[1];
        if ((x3 >= Math.min(x1, x2) && x3 <= Math.max(x1, x2)) && (y3 >= Math.min(y1, y2) && y3 <= Math.max(y1, y2))) return true;
        return false;
    }

    public static void main(String[] args) {
        int[][] input1 = {{1,1}, {2,2}, {3,3}};
        int[][] input2 = {{6,2}, {4,4}, {2,6}};
        int[][] input3 = {{3,1}, {1,3}, {1,1}};
        NumberOfPairs n = new NumberOfPairs();
        System.out.println(n.numberOfPairs(input1));
        System.out.println(n.numberOfPairs(input2));
        System.out.println(n.numberOfPairs(input3));
    }
}
