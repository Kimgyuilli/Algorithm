class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long cur = mass;
        long max = asteroids[asteroids.length - 1];

        for (int asteroid : asteroids) {
            if (cur < asteroid) return false;
            cur += asteroid;
            if (cur > max) return true;
        }

        return true;
    }
}