class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int result = 0;
        int idx = 0;
        
        if(ruleKey.equals("color")) idx = 1;
        else if(ruleKey.equals("name")) idx = 2;

        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).get(idx).equals(ruleValue)) result++;
        }
        return result;
    }
}