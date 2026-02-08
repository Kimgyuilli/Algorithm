import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        int sum = 0;
        int count = 0;
        
        for(int cost : d) {
            if(sum + cost <= budget) {
                sum += cost;
                count++;
            } else {
                break;
            }
        }
        
        return count;
    }
}