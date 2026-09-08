//하 샤갈!

class Solution {
    public String makeLargestSpecial(String s) {
        List<String> splits = new ArrayList<>();

        int count = 0;
        int start = 0;

        for(int i = 0; i < s.length(); i++) {
            count += s.charAt(i) == '1' ? 1 : -1;

            if(count == 0) {
                String find = s.substring(start + 1, i);

                splits.add("1" + makeLargestSpecial(find) + "0");

                start = i + 1;
            }
        }

        splits.sort(Collections.reverseOrder());

        return String.join("", splits);
    }
}