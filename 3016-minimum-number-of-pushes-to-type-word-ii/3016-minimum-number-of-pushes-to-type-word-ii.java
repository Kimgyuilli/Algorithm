class Solution {
    public int minimumPushes(String word) {
        
        int[] alpCount = new int[26];

        for(char c : word.toCharArray()) {
            alpCount[c - 'a']++;
        }

        Arrays.sort(alpCount);

        int answer = 0;
        int count = 0;
        int mux = 0;
        for(int i = 25; i >= 0; i--) {
            int n = alpCount[i];
            if(n == 0) break;
            if(count % 8 == 0) {
                mux++;
                count = 0;
            }
            answer += mux * n;
            count++;
        }

        return answer;
    }
}