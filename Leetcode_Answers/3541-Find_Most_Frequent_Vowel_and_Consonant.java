class Solution {
    public int maxFreqSum(String s){ 
        HashMap<Character, Integer> alphabet = new HashMap<>();
        char[] letters = s.toCharArray();
        char[] vowels = {'a','e','i','o','u'};
        int vNum = 0;
        int cNum = 0;
        boolean isVowel = false;

        for(int i = 0; i < s.length();i++){
            if(alphabet.containsKey(letters[i])){
                alphabet.put(letters[i], alphabet.get(letters[i])+1);
            }else{
                alphabet.put(letters[i],1);
            }
        }

        for(int i = 0; i< letters.length; i++){
            char current = letters[i];
            int currentCount = alphabet.get(current);
            isVowel = false;
            for(char c : vowels){
                if(c == current){
                    isVowel = true;
                    System.out.println(current);
                }
            }

            for(int j = 0; j< vowels.length; j++){
                if(current == vowels[j]){
                    if(vNum < currentCount){
                    vNum = alphabet.get(current);
                    }
                }else{
                    if(isVowel == false && cNum < currentCount){
                      System.out.println(current);
                      cNum = alphabet.get(current);
                    }
                }
            }
        }
        System.out.println(vNum);
        System.out.println(cNum);
        return vNum + cNum;
    }
}
