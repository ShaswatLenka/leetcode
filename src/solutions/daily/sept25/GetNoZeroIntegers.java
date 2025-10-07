package solutions.daily.sept25;

/*
1317: Convert Integer to the Sum of two No-Zero Integers [EASY]
 */

import java.util.Arrays;

public class GetNoZeroIntegers {

    public int[] getNoZeroIntegers(int n) {
        int a = 1, b = n-a;
        while(true) {
            if (!String.valueOf(a).contains("0") && !String.valueOf(b).contains("0")) return new int[]{a,b};
            else {
                a++;
                b--;
            }
        }
    }

    public static void main(String[] args) {
        GetNoZeroIntegers g = new GetNoZeroIntegers();
        System.out.println(Arrays.toString(g.getNoZeroIntegers(109)));
        System.out.println(Arrays.toString(g.getNoZeroIntegers(11)));
        System.out.println(Arrays.toString(g.getNoZeroIntegers(2)));
    }
}
