class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        char[] allowedArr = allowed.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        int letterCount = 0;
        
        for(String word : words){
            char[] letters = word.toCharArray();

            for(char c : letters){
                set.add(c);
            }

            for(char c : allowedArr){
                if(set.contains(c)){
                    letterCount++;
                }
            }

            if(set.size() == letterCount){count++;}
            set.clear();
            letterCount = 0;
        }
        return count;
    }
}
