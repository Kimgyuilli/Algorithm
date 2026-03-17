class Solution {
    public int solution(int[] a) {
        if (a.length <= 2) return a.length;

        int n = a.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        int min = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] < min) min = a[i];
            leftMin[i] = min;
        }

        min = a[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] < min) min = a[i];
            rightMin[i] = min;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] <= leftMin[i] || a[i] <= rightMin[i]) {
                answer++;
            }
        }

        return answer;
    }
}