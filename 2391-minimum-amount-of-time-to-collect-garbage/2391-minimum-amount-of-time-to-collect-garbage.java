class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {

        int len = garbage.length;

        // 0. M, 1. P, 2. G
        int[][] log = new int[3][2];

        int[] prefixSum = new int[len];
        for(int i = 1; i < len; i++) {
            prefixSum[i] += prefixSum[i-1] + travel[i-1];
        }

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < garbage[i].length(); j++) {
                char c = garbage[i].charAt(j);
                int idx;
                if(c == 'M') idx = 0;
                else if(c == 'P') idx = 1;
                else idx = 2;

                log[idx][0] = i;
                log[idx][1]++;
            }
        }

        int sum = 0;

        for(int i = 0; i < 3; i++) {
            sum += prefixSum[log[i][0]] + log[i][1];
        }
        
        return sum;
    }
}