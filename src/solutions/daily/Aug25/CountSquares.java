package solutions.daily.Aug25;

/*
*
* 1277: Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
*
* */
public class CountSquares {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int sol = 0;
        // base case: all cells with value 1 are valid squares
        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<cols; j++) {
               if(matrix[i][j] == 1) {
                   dp[i][j] = 1;
               }
            }
        }
        // Recurrence
        for (int i = rows - 1; i>=0; i--) {
            for (int j = cols - 1; j>=0; j--) {
                if (i + 1 < rows && j + 1 < cols) {
                    if (matrix[i][j] == 1 && dp[i+1][j+1] >= 1 && dp[i+1][j] >= 1 && dp[i][j+1] >= 1) {
//                        System.out.printf("i = %d, j=%d%n", i, j);
                        dp[i][j] = Math.min(dp[i+1][j+1], Math.min(dp[i][j+1], dp[i+1][j])) + 1;
                    }
                }
            }
        }

        // test
        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<cols; j++) {
                sol += dp[i][j];
            }
        }

        return sol;
    }

    public static void main(String[] args) {
        CountSquares c = new CountSquares();
        int[][] input = {{0,1,1,1}, {1,1,1,1}, {0,1,1,1}};
        System.out.println(c.countSquares(input));
    }
}
