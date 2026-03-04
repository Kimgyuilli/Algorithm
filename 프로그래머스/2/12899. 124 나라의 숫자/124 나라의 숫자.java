class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            int nameoji = n % 3;
            n = n / 3;
            if(nameoji == 0) {
                sb.append(4);
                n -= 1;
            } else {
                sb.append(nameoji);
            }
        }
        
        return sb.reverse().toString();
    }
}