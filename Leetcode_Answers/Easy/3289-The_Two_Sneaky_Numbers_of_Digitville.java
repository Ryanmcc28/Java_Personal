class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int[] sneakies = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                if (sneakies[0] == 0) {
                    sneakies[0] = nums[i];
                } else {
                    sneakies[1] = nums[i];
                }
            }
        }
        return sneakies;
    }
}
