class Solution {
    public boolean solution(int x) {
        
        char[] ch = String.valueOf(x).toCharArray();
        
        int sum = 0;
        
        for(char c : ch){
            sum += c - '0';
        }
        
        return (x % sum) == 0;
    }
}