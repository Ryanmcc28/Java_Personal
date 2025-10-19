class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];

        Map<Integer, Integer> map = new HashMap<>();

        //FILL MAP
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (map.containsKey(current))
                map.put(current, map.get(current) + 1);
            else
                map.put(current, 1);
        }

        for (int i = 0; i < k; i++) {
            int biggest = 0;
            int biggestKey = 0;
            for (Integer key : map.keySet()) {
                if (map.get(key) > biggest) {
                    biggest = map.get(key);
                    biggestKey = key;
                }
            }
            ans[i] = biggestKey;
            map.remove(biggestKey);
        }
        return ans;
    }
}
