class Solution {

    public int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int smallest = 9;

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            if (nums[i] < smallest) {
                smallest = nums[i];
            }
        }
        if (smallest != 0) {
            return 0;
        }

        for (int i = smallest; i < nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            } else if (i == nums.length - 1) {
                return nums.length;
            }

        }
        return 0;
    }
}
