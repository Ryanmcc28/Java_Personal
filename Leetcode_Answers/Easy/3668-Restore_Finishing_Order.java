class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] places = new int[friends.length];

        for(int i = 0; i < order.length; i++){
            for(int j = 0; j < friends.length; j++){
                if(order[i] == friends[j]){ 
                    list.add(order[i]);
                }
            }
        }
        for(int i = 0; i < list.size(); i++){
            places[i] = list.get(i);
        }
        return places;
    }
} 
