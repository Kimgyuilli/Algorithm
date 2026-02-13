import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        Map<String, Integer> users = new HashMap<>();
        int[] present_rate = new int[friends.length];
        int[][] present_count = new int[friends.length][friends.length];
        
        // 1. 조회용 friends 인덱스 초기화
        for(int i = 0; i < friends.length; i++){
            users.put(friends[i], i);
            present_count[i][i] = -1;
        }
        
        // 2. 선물 지수 계산
        for(String g : gifts){
            String[] friend = g.split(" ");
            int give = users.get(friend[0]);
            int recive = users.get(friend[1]);
            present_rate[give]++;
            present_rate[recive]--;
            present_count[give][recive]++;
        }
        
        int[] next_month = new int[friends.length];
        
        // 3. 다음달 받는 선물 수 계산
        for(int i = 0; i < friends.length - 1; i++){
            for(int j = i + 1; j < friends.length; j++){
                
                int recive = 0;
                
                // 3.1 주고받은 선물 개수 비교
                if(present_count[i][j] > present_count[j][i]) {
                    next_month[i]++;
                    continue;
                } else if(present_count[i][j] < present_count[j][i]) {
                    next_month[j]++;
                    continue;
                }
                
                // 3.2 주고받은 선물 개수가 같을 때 선물지수 비교
                if(present_rate[i] > present_rate[j]) {
                    next_month[i]++;
                } else if(present_rate[i] < present_rate[j]) {
                    next_month[j]++;
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < next_month.length; i++){
            if(next_month[i] > max){
                max = next_month[i];
            }
        }
        
        
        return max;
    }
}