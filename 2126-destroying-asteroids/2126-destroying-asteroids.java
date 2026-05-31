import java.util.*;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int max = asteroids[asteroids.length-1];
        for(int i : asteroids) {
            if(mass < i) return false;
            mass += i;
            if(mass > max) return true;
        }
        return true;
    }
}