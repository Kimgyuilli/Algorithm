class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        StringBuilder sb = new StringBuilder();
        
        for(int i : win_nums){
            sb.append(" ").append(i).append(" ");
        }
        
        String winNum = sb.toString();
        
        int correct = 0;
        int zeroCount = 0;
        
        for(int i : lottos){
            if(i == 0){
                zeroCount++;
                continue;
            }
            if(winNum.contains(" " + i + " ")) correct++;
        }
        
        int rank[] = {6, 6, 5, 4, 3, 2, 1};
        int min = rank[correct];
        int max = rank[correct + zeroCount];
        
        return new int[] {max, min};
    }
}