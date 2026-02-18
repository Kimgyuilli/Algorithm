class Solution {
    String[] vowels = {"A", "E", "I", "O", "U"};
    int count = 0;
    int answer = 0;
    boolean found = false;

    public int solution(String word) {
        dfs("", word);
        return answer;
    }

    private void dfs(String current, String target) {
        if (found) return;

        if (current.equals(target)) {
            answer = count;
            found = true;
            return;
        }

        if (current.length() == 5) return;

        for (int i = 0; i < 5; i++) {
            count++;
            dfs(current + vowels[i], target);
        }
    }
}