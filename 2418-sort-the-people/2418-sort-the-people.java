class Solution {

    private class People implements Comparable<People>{
        String name;
        int height;

        People(String name, int height) {
            this.name = name;
            this.height = height;
        }

        @Override
        public int compareTo(People p) {
            return Integer.compare(this.height, p.height);
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {

        int len = names.length;
        
        List<People> li = new ArrayList<>();

        for(int i = 0; i < len; i++) {
            li.add(new People(names[i], heights[i]));
        }

        li.sort(Collections.reverseOrder());


        for(int i = 0; i < len; i++) {
            names[i] = li.get(i).name;
        }

        return names;
    }
}