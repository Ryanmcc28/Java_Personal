class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts[i].length; j++) {
                count += accounts[i][j];
            }
            if (count > max) {
                max = count;
                count = 0;
            } else {
                count = 0;
            }
        }
        return max;
    }
}
