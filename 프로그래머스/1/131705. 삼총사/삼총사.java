class Solution {
    int answer = 0;
    
    public int solution(int[] number) {
        search(number, 0, 0, 0);
        return answer;
    }
    
    private void search(int[] arr, int start, int depth, int sum) {
        if(depth == 3) {
            if(sum == 0) answer++;
            return;
        }
        
        for(int i = start; i < arr.length; i++) {
            search(arr, i + 1, depth + 1, sum + arr[i]);
        }
    }
}