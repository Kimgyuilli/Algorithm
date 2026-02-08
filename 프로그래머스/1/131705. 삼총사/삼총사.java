class Solution {
    int answer = 0;
    public int solution(int[] number) {
        
        boolean[] visited = new boolean[number.length];
        search(number, visited, 0, number.length, 0);
        
        return answer;
    }
    
    private void search(int[] arr, boolean[] visited, int start, int length, int depth){
        if(depth == 3){
            int sum = 0;
            for(int i = 0; i < length; i++){
                if(visited[i]) sum += arr[i];
            }
            
            if(sum == 0) answer++;
            return;
        }
        
        for(int i = start; i < length; i++){
            visited[i] = true;
            search(arr, visited, i + 1, length, depth + 1);
            visited[i] = false;
        }
        
    }
    
}