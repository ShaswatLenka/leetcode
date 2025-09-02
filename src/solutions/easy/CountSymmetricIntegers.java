package solutions.easy;

public class CountSymmetricIntegers {
    private int calculateNumberOfDigits(int num) {
        int numDigits = 0;
        while(num > 0) {
            numDigits++;
            num = num/10;
        }
        return numDigits;
    }

    public int countSymmetricIntegers(int low, int high) {
        int digits = 0;
        for (int i=low; i<=high; i++) {
            int num = i;
            int numDigits = calculateNumberOfDigits(i);
            if (numDigits % 2 == 0) {
                int firstHalfSum=0, secondHalfSum=0;
                for (int j=0; j<numDigits; j++) {
                    if (j < numDigits/2) {
                       secondHalfSum += num%10;
                    } else {
                       firstHalfSum += num%10;
                    }
                    num = num/10;
                }
                if (firstHalfSum == secondHalfSum) digits++;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int low = 1, high = 100;
        CountSymmetricIntegers c = new CountSymmetricIntegers();
        System.out.println(c.countSymmetricIntegers(low, high));
    }
}
