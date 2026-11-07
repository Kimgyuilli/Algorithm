class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int count1 = 0;
        int count2 = 0;

        int[] answer = new int[seq.length()];

        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);

            if (c == '(') {
                if (count1 <= count2) {
                    count1++;
                    answer[i] = 0;
                } else {
                    count2++;
                    answer[i] = 1;
                }
            } else {
                if (count1 >= count2 && count1 > 0) {
                    count1--;
                    answer[i] = 0;
                } else {
                    count2--;
                    answer[i] = 1;
                }
            }
        }

        return answer;
    }
}