class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> groups = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int person = 0; person < groupSizes.length; person++) {
            int groupSize = groupSizes[person];

            List<Integer> group;

            if (!groups.containsKey(groupSize)) {
                groups.put(groupSize, new ArrayList<>());
            }

            group = groups.get(groupSize);
            group.add(person);

            if (group.size() == groupSize) {
                result.add(group);
                groups.remove(groupSize);
            }
        }

        return result;
    }
}