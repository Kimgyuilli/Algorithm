class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();

        int max = 0;

        for(int n : candies) {
            max = Math.max(n, max);
        }

        int trueNum = max - extraCandies;

        for(int n : candies) { 
            if(n >= trueNum) result.add(true);
            else result.add(false);
        }
        return result;

    }
}