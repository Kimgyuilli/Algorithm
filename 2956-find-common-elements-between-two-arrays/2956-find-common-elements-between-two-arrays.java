class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        
        boolean[] n1 = new boolean[101];
        boolean[] n2 = new boolean[101];

        for(int n : nums1) {
            n1[n] = true;
        }

        int answer2 = 0;
        for(int n : nums2) {
            n2[n] = true;
            if(n1[n])answer2++;
        }

        int answer1 = 0;
        for(int n : nums1) {
            if(n2[n])answer1++;
        }
        return new int[] {answer1, answer2};
    }
}