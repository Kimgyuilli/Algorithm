class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int position = 1;
        
        for(int station : stations) {
            int left = station - w;
            
            if(left > position) {
                int gap = left - position;
                answer += (gap + (w * 2)) / (w * 2 + 1);
            }
            
            position = station + w + 1;
        }
        
        if(position <= n) {
            int gap = n - position + 1;
            answer += (gap + (w * 2)) / (w * 2 + 1);
        }
        

        return answer;
    }
}