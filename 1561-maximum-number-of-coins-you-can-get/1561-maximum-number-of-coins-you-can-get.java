class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int answer = 0;

        for(int i = piles.length - 2; i >= piles.length / 3; i -= 2) {
            answer += piles[i];
        }
        return answer;
    }
}