class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int count = 0;
        int sum = 0;
        for(int i = cost.length - 1; i >= 0; i--) {
            if(count < 2) {
                sum += cost[i];
            }
            count = (count + 1) % 3;
        }
        return sum;
    }
}