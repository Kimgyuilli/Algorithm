import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int answer = 0;
        int[] student = new int[n];
        
        Arrays.fill(student, 1);
        
        for(int i : lost){
            student[i-1]--;
        }
        
        for(int i : reserve){
            student[i-1]++;
        }
        
        for(int i = 0; i < n; i++){
            if(student[i] > 0) {
                answer++;
                continue;
            }
            
            if(i > 0 && student[i-1] == 2){
                student[i-1]--;
                student[i]++;
                answer++;
            } else if(i < n - 1 && student[i + 1] == 2){
                student[i+1]--;
                student[i]++;
                answer++;
            }
            
        }
        
        return answer;
    }
}