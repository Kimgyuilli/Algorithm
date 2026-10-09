class Solution
{
    public int solution(String s)
    {
        int len = s.length();
        int answer = 1;
        
        for(int i = 0; i < len; i++) {
            int left = i;
            int right = len;
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
        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}