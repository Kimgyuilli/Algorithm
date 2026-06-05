class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if(rec1[0] >= rec2[2] ||  // rec1 왼쪽 >= rec2 오른쪽
rec1[1] >= rec2[3] ||  // rec1 아래 >= rec2 위
rec1[2] <= rec2[0] ||  // rec1 오른쪽 <= rec2 왼쪽
rec1[3] <= rec2[1] ) return false;
        return true;
    }
}