class Solution {
    public int[] solution(int n, int k) {
        int[] answer = new int[n/k];
        
        int index = 0;
        for(int i = 1; i <= n/k; i++){
            answer[index++] = i*k;
        }
        
        return answer;
    }
}