class Solution {
    public int solution(int[] cards) {
        int n = cards.length;
        int[] group = new int[n + 1]; 
        boolean[] visited = new boolean[n];
        
        int groupIdx = 0;
        
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue; 
            
            int current = i;
            
            while(!visited[current]) {
                visited[current] = true;
                current = cards[current] - 1; 
                group[groupIdx]++;
            }
            groupIdx++;
        }
        
        if(groupIdx < 2) return 0;
        
        int first = 0;
        int second = 0;
        
        for(int i = 0; i < groupIdx; i++) {
            if(group[i] > first) {
                second = first;
                first = group[i];
            } else if(group[i] > second) {
                second = group[i];
            }
        }
    
        return first * second;
    }
}