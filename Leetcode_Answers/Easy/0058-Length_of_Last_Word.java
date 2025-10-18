class Solution {
    public int lengthOfLastWord(String s) {
        String[] strArray = s.split(" ");
        return strArray[strArray.length - 1].length();
    }
}
