class Solution {
    public int maximum69Number (int num) {
        int max = -1;

        int copy = num;
        int cur = 1;
        while(copy > 0) {

            int n = copy % 10;
            if(n == 6) {
                max = cur;
            }
            cur *= 10;
            copy /= 10;
        }

        if(max == -1) return num;

        return num + max * 3;

    }
}