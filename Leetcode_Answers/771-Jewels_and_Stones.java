class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        char[] jewelArr = jewels.toCharArray();
        char[] stoneArr = stones.toCharArray();

        int jewelCount = 0;
        for(int i=0; i < stoneArr.length; i++){
            for(int j=0; j < jewelArr.length; j++){
                if(jewelArr[j] == stoneArr[i]){
                    jewelCount++;
                }
            }
        }
        return jewelCount;
    }
}
