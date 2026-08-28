class Solution {
    public int countTriplets(int[] arr) {
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            int xor = 0;

            for (int k = i; k < arr.length; k++) {
                // arr[i]부터 arr[k]까지의 XOR
                xor ^= arr[k];

                // 전체 구간의 XOR이 0이면
                // i < j <= k인 모든 j가 조건을 만족
                if (xor == 0) {
                    answer += k - i;
                }
            }
        }

        return answer;
    }
}