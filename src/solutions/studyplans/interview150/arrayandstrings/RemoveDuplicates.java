package solutions.studyplans.interview150.arrayandstrings;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int reader = 0; int writer = 0;
        while (reader < nums.length) {
            if (nums[reader] == nums[writer]) {
                reader++;
            } else {
                writer++;
                nums[writer] = nums[reader];
            }
        }
        return writer + 1;
    }

    private class removeDuplicatesII {
        private static int removeDuplicates(int[] nums) {
            int writer=0, reader=0, ctr=0, prev=nums[0];

            while(reader < nums.length) {
                if (nums[reader] != prev) {
                    ctr = 0;
                }
                if (ctr < 2) {
                    nums[writer] = nums[reader];
                    prev = nums[reader];
                    writer++;
                    ctr++;
                }
                reader++;
            }
            return writer;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicates r = new RemoveDuplicates();
        int[] input = {1,1,1,2,2,2,3,3};
        System.out.println(RemoveDuplicates.removeDuplicatesII.removeDuplicates(input));
    }
}
