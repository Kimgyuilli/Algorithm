class Solution {
    public int findClosest(int x, int y, int z) {
        int compare = Math.abs(z-x) - Math.abs(z-y);
        
        if(compare < 0) return 1;
        if(compare > 0) return 2;
        
        return 0;


    }
}