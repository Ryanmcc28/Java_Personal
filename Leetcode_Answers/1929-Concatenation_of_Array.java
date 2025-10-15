class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];  
        int count = 0;
        for(int i=0; i < ans.length; i++){
            ans[i] = nums[count];
            if(count >= nums.length-1){count = 0;}
            else{count++;}
        }    
        return ans;
    }
}
