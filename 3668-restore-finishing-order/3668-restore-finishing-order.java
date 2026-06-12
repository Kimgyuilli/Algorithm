class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer> set = new HashSet<>();

        for(int n : friends) {
            set.add(n);
        }
        
        int[] result = new int[friends.length];
        int idx = 0;
        for(int n : order) {
            if(set.contains(n)) {
                result[idx++] = n;
            }
        }
        return result;

    }
}