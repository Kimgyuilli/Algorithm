class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        while(true) {
            boolean changed = false;
            
            for(int i = 0; i < arr.length; i++){
                int prev = arr[i];
                
                if(arr[i] >= 50 && arr[i] % 2 == 0){
                    arr[i] /= 2;
                } else if(arr[i] < 50 && arr[i] % 2 == 1){
                    arr[i] = arr[i] * 2 + 1;
                }
                
                if(prev != arr[i]) changed = true;
            }
            
            if(!changed) break; 
            
            answer++;
        }
        
        return answer;
    }
}