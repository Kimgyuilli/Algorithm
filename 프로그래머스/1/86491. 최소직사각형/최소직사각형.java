import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;
        
        for(int[] li : sizes){
            
            int bigger = Math.max(li[0], li[1]);
            int smaller = Math.min(li[0], li[1]);
            
            if(bigger > max) max = bigger;
            if(smaller > min) min = smaller;
        }
        return max * min;
    }
}