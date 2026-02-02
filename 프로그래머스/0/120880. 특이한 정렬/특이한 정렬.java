import java.util.Arrays;

class Solution {
    public int[] solution(int[] numlist, int n) {
    
        int[][] temp = new int[numlist.length][2];
        
        for(int i = 0; i < numlist.length; i++){
            temp[i][0] = numlist[i];
            temp[i][1] = Math.abs(numlist[i] - n);
        }
        
        Arrays.sort(temp, (o1, o2) -> {
            int num = o1[1] == o2[1] ? o2[0]-o1[0] : o1[1] - o2[1];
            return num;
        });
        
        int[] answer = new int[numlist.length];
        
        for(int i = 0; i < numlist.length; i++){
            answer[i] = temp[i][0];
        }
        
        return answer;
    }
}