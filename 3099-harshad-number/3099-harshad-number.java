class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int hNum = 0;
        int copy = x;
        while(copy > 0) {
            hNum += copy % 10;
            copy /= 10;
        }

        if(x % hNum == 0) return hNum;
        return -1;
    }
}