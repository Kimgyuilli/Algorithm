import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        Map<String, Integer> user_index = new HashMap<>();
        Map<String, Integer> report_count = new HashMap<>(); // 신고당한 횟수 count
        Set<String> report_log = new HashSet<>(); // 신고 기록
        
        // 1. 유저 신고당한 횟수 초기화
        int idx = 0;
        for(String id : id_list){
            user_index.put(id, idx++);
            report_count.put(id, 0);
        }
        
        // 2. 신고 event 처리
        for(String r : report){
            if(report_log.contains(r)) continue;
            report_log.add(r);
            String reported = r.split(" ")[1];
            report_count.put(reported, report_count.get(reported) + 1);
            
        }
        
        boolean[] isOut = new boolean[id_list.length]; // 유저별 정지 여부
        
        // 3. 유저 정지 상태 계산
        for(int i = 0; i < id_list.length; i++){
            if(report_count.get(id_list[i]) >= k) isOut[i] = true;
        }
        
        int[] answer = new int[id_list.length];
        
        // 4. 신고한 유저가 정지된 개수 계산
        for(String s : report_log){
            String[] report_user = s.split(" ");
            if(isOut[user_index.get(report_user[1])]){
                answer[user_index.get(report_user[0])]++;
            }
            
        }
        
        return answer;
    }
}