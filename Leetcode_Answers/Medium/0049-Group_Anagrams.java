class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> keyMap = new HashMap<>();

        List<List<String>> anaLists = new ArrayList<>();

        //FIND KEYS
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String current = new String(charArray);

            if (keyMap.containsKey(current)) {
                keyMap.get(current).add(strs[i]);
            } else {
                keyMap.put(current, new ArrayList<>());
                keyMap.get(current).add(strs[i]);
            }
        }
        return new ArrayList<>(keyMap.values());
    }
}
