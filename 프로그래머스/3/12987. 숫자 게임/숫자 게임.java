import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int bPointer = 0;
        for(int emp : A) {
            while(bPointer < B.length && B[bPointer] <= emp) {
                bPointer++;
            }
            
            if(bPointer < B.length) {
                bPointer++;
                answer++;
            }
        }
        
        return answer;
    }
}