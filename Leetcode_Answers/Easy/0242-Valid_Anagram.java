class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        if (Arrays.equals(sArray, tArray))
            return true;
        else
            return false;

    }
}
