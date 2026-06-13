class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for(String s : operations) {
            if(s.charAt(1) == '+') result++;
            else result--;
        }
        return result;
    }
}