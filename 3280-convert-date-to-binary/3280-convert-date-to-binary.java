class Solution {
    public String convertDateToBinary(String date) {
        String[] parsed = date.split("-");

        for(int i = 0; i < 3; i++) {
            parsed[i] = Integer.toString(Integer.parseInt(parsed[i]), 2);
        }

        return String.join("-", parsed);
    }
}