class Solution {
    public int alternatingSum(int[] nums) {
        int altSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0)
                altSum += nums[i];
            else
                altSum -= nums[i];
        }
        return altSum;
    }
}
