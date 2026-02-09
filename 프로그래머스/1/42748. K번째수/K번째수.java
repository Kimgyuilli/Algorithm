import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int k = commands[i][2] - 1;  
            
            // 1. 배열 자르기
            int[] temp = Arrays.copyOfRange(array, start, end);
            
            // 2. 정렬
            Arrays.sort(temp);
            
            // 3. k번째 수 가져오기
            answer[i] = temp[k];
        }
        
        return answer;
    }
}