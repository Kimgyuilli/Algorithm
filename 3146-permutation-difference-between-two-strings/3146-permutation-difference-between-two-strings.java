class Solution {
    public int findPermutationDifference(String s, String t) {
        int[] alp1 = new int[26];
        int[] alp2 = new int[26];
        int len = s.length();
        for(int i = 0; i < len; i++) {
            alp1[s.charAt(i) - 'a'] = i;
            alp2[t.charAt(i) - 'a'] = i;
        }

        int result = 0;

        for(int i = 0; i < len; i++) {
            result += Math.abs(alp1[s.charAt(i) - 'a'] - alp2[s.charAt(i) - 'a']);
            System.out.println(result);
        }
        return result;

    }
}