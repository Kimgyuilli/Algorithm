class Solution {
    public int solution(int[] a) {
        
        int len = a.length;
        int[] leftMin = new int[len];
        int[] rightMin = new int[len];
    
        leftMin[0] = a[0];    
        for(int i = 1; i < len; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }
        
        rightMin[len - 1] = a[len - 1];    
        for(int i = len - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }
                
        int answer = 0;
        for(int i = 0; i < len; i++) {
            if(rightMin[i] == a[i] || leftMin[i] == a[i]) answer++;
        }
        
        return answer;
    }
}