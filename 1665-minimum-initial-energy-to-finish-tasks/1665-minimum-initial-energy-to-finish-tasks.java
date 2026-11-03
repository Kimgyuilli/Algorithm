class Solution {
    public int minimumEffort(int[][] tasks) {
        int start = 0;
        int energy = 0;

        Arrays.sort(tasks, (a, b) -> {
            int diffA = a[1] - a[0];
            int diffB = b[1] - b[0];
            if(diffA == diffB) return a[1] - b[1];
            return diffB - diffA;
        });

        for(int[] task : tasks) {
            int actual = task[0];
            int minimum = task[1];

            if(energy < minimum) {
                int require = minimum - energy;
                energy += require;
                start += require;
            }
            energy -= actual;
        }
        return start;
    }
}