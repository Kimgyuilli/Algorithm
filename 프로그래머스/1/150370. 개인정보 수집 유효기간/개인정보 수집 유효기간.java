import java.util.*;

class Solution {
    String parsed_today;
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        parsed_today = today.replace(".", "");
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(String term : terms){
            String[] parts = term.split(" ");
            map.put(parts[0].charAt(0), Integer.parseInt(parts[1]));
        }
        
        List<Integer> answer = new ArrayList<>();
        
        int index = 1;
        for(String privacy : privacies){
            
            char policy = privacy.charAt(11);
            String expired_at = getExpirationDay(privacy.substring(0, 10), map.get(policy));
            
            if(isExpired(expired_at)){
                answer.add(index);
            }
            
            index++;
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private String getExpirationDay(String date, int policy){
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        String day = date.substring(8, 10);
        
        month += policy;
        
        if(month > 12){
            year += (month - 1) / 12;
            month = (month - 1) % 12 + 1;
        }
        
        String string_month = String.valueOf(month);
        if(month < 10){
            string_month = "0" + month;
        }
        
        return year + string_month + day;
    }
    
    private boolean isExpired(String expired_at){
        
        System.out.println(parsed_today + " " + expired_at);
        
        return Integer.parseInt(parsed_today) >= Integer.parseInt(expired_at) ? true : false;
    }
    
}