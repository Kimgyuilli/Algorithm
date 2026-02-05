class Solution {
    public int solution(String[] strArr) {
        
        int[] list = new int[31];
        
        int answer = 0;
        
        for(String s : strArr){
            list[s.length()]++;
        }
        
        for(int i : list){
            if(i > answer) answer = i;
        }
        
        return answer;
    }
}