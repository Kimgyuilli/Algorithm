class Solution {
    public int[] solution(int[] arr) {
        int startIdx = -1;
        int endIdx = -1;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 2){
                if(startIdx == -1) {
                    startIdx = i;
                } else if (endIdx == -1) {
                    endIdx = i;
                } else{
                    endIdx = i;
                }
            }
        }
        
        if(startIdx == -1) return new int[] {-1};
        if(endIdx == -1) return new int[] {2};
        
        int[] answer = new int[endIdx - startIdx + 1];
        
        
        int index = 0;
        for(int i = startIdx; i <= endIdx; i++){
            answer[index++] = arr[i];
        }
        
        
        return answer;
    }
}