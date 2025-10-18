class Solution {
    public int[] transformArray(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (number % 2 == 0) {
                nums[i] = 0;
            } else {
                nums[i] = 1;
            }
        }
        int temp = 0;

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int previous = nums[i - 1];

            if (previous > current) {
                temp = current;
                nums[i] = previous;
                nums[i - 1] = temp;
                i = 0;
            }
        }
        return nums;
    }
}
