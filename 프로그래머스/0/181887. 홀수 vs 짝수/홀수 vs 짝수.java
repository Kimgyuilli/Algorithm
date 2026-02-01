import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        
        int n1 = 0, n2 = 0;
        
        for(int i = 0; i < num_list.length; i++){
            if(i % 2 == 0){
                n1 += num_list[i];
                continue;
            } 
            n2 += num_list[i];
        }
        
        return Math.max(n1, n2);
    }
}