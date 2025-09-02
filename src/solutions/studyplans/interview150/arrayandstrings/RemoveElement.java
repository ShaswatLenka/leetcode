package solutions.studyplans.interview150.arrayandstrings;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
      int reader = 0, writer = 0;
      while(reader < nums.length) {
          if (nums[reader] == val) {
              reader++;
          } else {
              nums[writer] = nums[reader];
              reader++;
              writer++;
          }
      }
      return writer;
    }

    public static void main(String[] args) {
        RemoveElement r = new RemoveElement();
        int[] inp = {3,2,2,3}; int val = 3;
        System.out.println(r.removeElement(inp, val));
    }
}
