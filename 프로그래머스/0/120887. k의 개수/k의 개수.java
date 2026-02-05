class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        String kStr = String.valueOf(k);
        
        for(int n = i; n <= j; n++){
            String nStr = String.valueOf(n);
            if(nStr.contains(kStr)){
                String removed = nStr.replace(kStr, "");
                answer += nStr.length() - removed.length();
            }
        }
        
        return answer;
    }
}