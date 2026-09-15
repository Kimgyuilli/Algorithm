import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int len = A.length;
        
        int idxA = 0;
        int idxB = 0;
        int answer = 0;
        
        while(idxA < len && idxB < len) {
            if(A[idxA] < B[idxB]) {
                idxA++;
                idxB++;
            } else {
                idxB++;
            }
        }
        
        return idxA;
    }
}