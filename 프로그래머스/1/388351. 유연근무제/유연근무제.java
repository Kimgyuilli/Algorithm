class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < timelogs.length; i++){
            int week = startday;
            int hour = schedules[i] / 100;
            int minute = schedules[i] % 100 + 10;
            
            if(minute > 59){
                hour += 1;
                minute %= 60;
            }
            
            int scheduled = hour * 100 + minute;
            
            boolean can_reward = true;
            
            for(int t : timelogs[i]){
                if(week != 6 && week != 7){
                    if(scheduled < t){
                        can_reward = false;
                        break;
                    }
                }
                week = (week - 1) % 7 + 2;
            }
            
            if(can_reward) answer++;
        }
        
        return answer;
    }
}