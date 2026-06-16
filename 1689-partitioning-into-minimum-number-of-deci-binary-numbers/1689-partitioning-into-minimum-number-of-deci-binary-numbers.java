class Solution {
    public int minPartitions(String n) {
        int min = 0;

        for(int i = 0; i < n.length(); i++) {
            int a = n.charAt(i) - '0';
            if(a == 9) return 9;
            if(a > min) min = a;
        }
        return min;
    }
}