class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return answer;
    }
    
    private void compress(int[][] arr, int x, int y, int size) {
        int first = arr[y][x];
        boolean same = true;
        
        for(int i = y; i < y + size; i++) {
            for(int j = x; j < x + size; j++) {
                if(arr[i][j] != first) {
                    same = false;
                    break;   
                }
            }
        }
        
        if(same) {
            answer[first]++;
            return;
        }
        
        int harf = size / 2;
        compress(arr, x, y, harf);
        compress(arr, x + harf, y, harf);
        compress(arr, x, y + harf, harf);
        compress(arr, x + harf, y + harf, harf);
    }
    
}