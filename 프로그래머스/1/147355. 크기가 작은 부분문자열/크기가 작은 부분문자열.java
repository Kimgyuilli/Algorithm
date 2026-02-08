class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pLen = p.length();
        long pValue = Long.parseLong(p);
        
        for (int i = 0; i <= t.length() - pLen; i++) {
            String sub = t.substring(i, i + pLen);
            if (Long.parseLong(sub) <= pValue) {
                answer++;
            }
        }
        
        return answer;
    }
}