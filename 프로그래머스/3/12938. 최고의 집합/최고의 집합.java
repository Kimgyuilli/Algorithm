class Solution {
    public int[] solution(int n, int s) {
        if(n > s) return new int[] {-1};
        
        int avg = s / n;
        int lest = s % n;
        
        int[] answer = new int[n];
        
        for(int i = n - 1; i >= 0; i--) {
            answer[i] = avg;
        }
        
        for(int i = n - 1; i > 0; i--) {
            if(lest <= 0) break;
            answer[i]++;
            lest--;
        }
        
        
        return answer;
    }
}