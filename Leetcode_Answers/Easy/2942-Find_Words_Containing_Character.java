class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for(int i=0; i < words.length; i++){
            if(words[i].contains(Character.toString(x))){ indexes.add(i);}
        }
        return indexes;
    }
}
