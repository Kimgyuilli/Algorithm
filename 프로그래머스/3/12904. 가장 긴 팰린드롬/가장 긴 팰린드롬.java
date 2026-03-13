class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        
        for(int i = 0; i < s.length(); i++) {
            
            int left = i;
            int right = s.length();
            while(left < right) {
                if(right - 1 - left < answer) break;
                if(isPalindrom(s, left, right - 1)) {
                    answer = right - left;
                }
                   right--;
            }
        }
        return answer;
    }
    
    private boolean isPalindrom(String s, int left, int right) {
        boolean flag = true;
        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}