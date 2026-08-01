class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {
        
        List<Integer> result = new ArrayList<>();

        int prev = height[0];
        for(int i = 1; i < height.length; i++) {
            if(prev > threshold) result.add(i);
            prev = height[i];
        }
        return result;
    }
}